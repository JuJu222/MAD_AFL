package com.example.moviedbafl.views;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.moviedbafl.R;
import com.example.moviedbafl.adapters.MoviesAdapter;
import com.example.moviedbafl.helpers.ItemClickSupport;
import com.example.moviedbafl.models.Movie;
import com.example.moviedbafl.viewmodels.MovieViewModel;

import java.util.List;

public class NowPlayingFragment extends Fragment {
    MoviesAdapter moviesAdapter;
    GridLayoutManager gridLayoutManager;
    boolean loading;
    int page;
    int pastVisiblesItems, visibleItemCount, totalItemCount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_now_playing, container, false);

        loading = false;
        page = 1;

        MovieViewModel movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);

        RecyclerView nowPlayingRecyclerView = view.findViewById(R.id.nowPlayingRecyclerView);
        ProgressBar nowPlayingProgressBar = view.findViewById(R.id.nowPlayingProgressBar);

        nowPlayingProgressBar.setVisibility(View.VISIBLE);

        movieViewModel.clearNowPlayingList();
        movieViewModel.getNowPlaying(page);
        movieViewModel.getNowPlayingResult().observe(getViewLifecycleOwner(), new Observer<List<Movie.NowPlayingUpcoming.Results>>() {
            @Override
            public void onChanged(List<Movie.NowPlayingUpcoming.Results> results) {
                moviesAdapter = new MoviesAdapter(getContext(), results, getResources().getString(R.string.now_playing));
                nowPlayingRecyclerView.setAdapter(moviesAdapter);
                gridLayoutManager = new GridLayoutManager(getContext(), 2);
                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        switch(moviesAdapter.getItemViewType(position)){
                            case MoviesAdapter.TYPE_HEADER:
                            case MoviesAdapter.TYPE_FOOTER:
                                return 2;
                            case MoviesAdapter.TYPE_ITEM:
                                return 1;
                            default:
                                return -1;
                        }
                    }
                });
                nowPlayingRecyclerView.setLayoutManager(gridLayoutManager);

                ItemClickSupport.addTo(nowPlayingRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("movieId", results.get(position -1).getId());
                        Navigation.findNavController(v).navigate(R.id.action_nowPlayingFragment_to_movieDetailsFragment, bundle);
                    }
                });

                nowPlayingProgressBar.setVisibility(View.GONE);
            }
        });

        nowPlayingRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                visibleItemCount = gridLayoutManager.getChildCount();
                totalItemCount = gridLayoutManager.getItemCount();
                pastVisiblesItems = gridLayoutManager.findFirstVisibleItemPosition();
                moviesAdapter.setIsLoading(true);

                if ((visibleItemCount + pastVisiblesItems) >= totalItemCount && !loading) {
                    loading = true;
                    page++;
                    movieViewModel.getNowPlaying(page);
                    movieViewModel.getNowPlayingResult().observe(getViewLifecycleOwner(), new Observer<List<Movie.NowPlayingUpcoming.Results>>() {
                        @SuppressLint("NotifyDataSetChanged")
                        @Override
                        public void onChanged(List<Movie.NowPlayingUpcoming.Results> results) {
                            System.out.println("loaded");
                            moviesAdapter.setNowPlayingUpcomingList(results);
                            moviesAdapter.notifyDataSetChanged();

                            loading = false;
                        }
                    });
                }
            }
        });

        return view;
    }
}