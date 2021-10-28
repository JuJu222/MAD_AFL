package com.example.moviedbafl.views;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
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

import com.example.moviedbafl.R;
import com.example.moviedbafl.adapters.MoviesAdapter;
import com.example.moviedbafl.helpers.ItemClickSupport;
import com.example.moviedbafl.models.Movie;
import com.example.moviedbafl.viewmodels.MovieViewModel;

import java.util.List;

public class NowPlayingFragment extends Fragment {
    MoviesAdapter moviesAdapter;
    GridLayoutManager gridLayoutManager;
    boolean loading = false;
    int page = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_now_playing, container, false);

        MovieViewModel movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);

        RecyclerView nowPlayingRecyclerView = view.findViewById(R.id.nowPlayingRecyclerView);
        NestedScrollView nowPlayingNestedScrollView = view.findViewById(R.id.nowPlayingNestedScrollView);

        movieViewModel.clearNowPlayingList();
        movieViewModel.getNowPlaying(page);
        movieViewModel.getNowPlayingResult().observe(getViewLifecycleOwner(), new Observer<List<Movie.NowPlayingUpcoming.Results>>() {
            @Override
            public void onChanged(List<Movie.NowPlayingUpcoming.Results> results) {
                moviesAdapter = new MoviesAdapter(getContext(), results);
                nowPlayingRecyclerView.setAdapter(moviesAdapter);
                gridLayoutManager = new GridLayoutManager(getContext(), 2);
                nowPlayingRecyclerView.setLayoutManager(gridLayoutManager);

                ItemClickSupport.addTo(nowPlayingRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("movieId", results.get(position).getId());
                        Navigation.findNavController(v).navigate(R.id.action_nowPlayingFragment_to_movieDetailsFragment, bundle);
                    }
                });
            }
        });

        nowPlayingNestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                double scrollViewHeight = nowPlayingNestedScrollView.getChildAt(0).getBottom() - nowPlayingNestedScrollView.getHeight();
                double getScrollY = nowPlayingNestedScrollView.getScrollY();
                double scrollPosition = (getScrollY / scrollViewHeight);

                if (scrollPosition == 1 && !loading) {
                    loading = true;
                    page++;
                    movieViewModel.getNowPlaying(page);
                    movieViewModel.getNowPlayingResult().observe(getViewLifecycleOwner(), new Observer<List<Movie.NowPlayingUpcoming.Results>>() {
                        @SuppressLint("NotifyDataSetChanged")
                        @Override
                        public void onChanged(List<Movie.NowPlayingUpcoming.Results> results) {
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