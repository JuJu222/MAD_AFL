package com.example.moviedbafl.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviedbafl.R;
import com.example.moviedbafl.adapters.CastsAdapter;
import com.example.moviedbafl.adapters.CrewAdapter;
import com.example.moviedbafl.adapters.ProductionCompaniesAdapter;
import com.example.moviedbafl.helpers.Const;
import com.example.moviedbafl.models.Movie;
import com.example.moviedbafl.viewmodels.MovieViewModel;

public class MovieDetailsFragment extends Fragment {
    boolean isDetailsLoaded = false;
    boolean isCreditsLoaded = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_details, container, false);

        int movieId = getArguments().getInt("movieId");

        MovieViewModel movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        ImageButton movieDetailsBackImageButton = view.findViewById(R.id.movieDetailsBackImageButton);
        ImageView movieDetailsImageView = view.findViewById(R.id.movieDetailsImageView);
        ImageView movieDetailsStarImageView = view.findViewById(R.id.movieDetailsStarImageView);
        ImageView movieDetailsPosterImageView = view.findViewById(R.id.movieDetailsPosterImageView);
        TextView movieDetailsTextView = view.findViewById(R.id.movieDetailsTextView);
        TextView movieDetailsTextView2 = view.findViewById(R.id.movieDetailsTextView2);
        TextView movieDetailsTextView3 = view.findViewById(R.id.movieDetailsTextView3);
        TextView movieDetailsTextView5 = view.findViewById(R.id.movieDetailsTextView5);
        TextView movieDetailsTextView6 = view.findViewById(R.id.movieDetailsTextView6);
        TextView movieDetailsTitleTextView = view.findViewById(R.id.movieDetailsTitleTextView);
        TextView movieDetailsTaglineTextView = view.findViewById(R.id.movieDetailsTaglineTextView);
        TextView movieDetailsReleaseDateTextView = view.findViewById(R.id.movieDetailsReleaseDateTextView);
        TextView movieDetailsVoteAverageTextView = view.findViewById(R.id.movieDetailsVoteAverageTextView);
        TextView movieDetailsOverviewTextView = view.findViewById(R.id.movieDetailsOverviewTextView);
        TextView movieDetailsGenresTextView = view.findViewById(R.id.movieDetailsGenresTextView);
        TextView movieDetailsFullReleaseDateTextView = view.findViewById(R.id.movieDetailsFullReleaseDateTextView);
        RecyclerView movieDetailsProductionCompaniesRecyclerView = view.findViewById(R.id.movieDetailsProductionCompaniesRecyclerView);
        RecyclerView movieDetailsCastsRecyclerView = view.findViewById(R.id.movieDetailsCastsRecyclerView);
        RecyclerView movieDetailsCrewRecyclerView = view.findViewById(R.id.movieDetailsCrewRecyclerView);
        ProgressBar movieDetailsProgressBar = view.findViewById(R.id.movieDetailsProgressBar);

        movieDetailsImageView.setVisibility(View.GONE);
        movieDetailsStarImageView.setVisibility(View.GONE);
        movieDetailsPosterImageView.setVisibility(View.GONE);
        movieDetailsTextView.setVisibility(View.GONE);
        movieDetailsTextView2.setVisibility(View.GONE);
        movieDetailsTextView3.setVisibility(View.GONE);
        movieDetailsTextView5.setVisibility(View.GONE);
        movieDetailsTextView6.setVisibility(View.GONE);
        movieDetailsTitleTextView.setVisibility(View.GONE);
        movieDetailsTaglineTextView.setVisibility(View.GONE);
        movieDetailsReleaseDateTextView.setVisibility(View.GONE);
        movieDetailsVoteAverageTextView.setVisibility(View.GONE);
        movieDetailsOverviewTextView.setVisibility(View.GONE);
        movieDetailsGenresTextView.setVisibility(View.GONE);
        movieDetailsFullReleaseDateTextView.setVisibility(View.GONE);
        movieDetailsProductionCompaniesRecyclerView.setVisibility(View.GONE);
        movieDetailsCastsRecyclerView.setVisibility(View.GONE);;
        movieDetailsCrewRecyclerView.setVisibility(View.GONE);
        movieDetailsProgressBar.setVisibility(View.VISIBLE);

        movieViewModel.getDetails(movieId);
        movieViewModel.getDetailsResult().observe(getViewLifecycleOwner(), new Observer<Movie.Details>() {
            @Override
            public void onChanged(Movie.Details details) {
                movieDetailsTitleTextView.setText(details.getTitle());
                movieDetailsTaglineTextView.setText(details.getTagline());
                movieDetailsReleaseDateTextView.setText(details.getRelease_date().substring(0, 4));
                String vote = "(" + details.getVote_count() + ") " + details.getVote_average();
                movieDetailsVoteAverageTextView.setText(vote);
                movieDetailsOverviewTextView.setText(details.getOverview());
                movieDetailsFullReleaseDateTextView.setText(details.getRelease_date());
                Glide.with(getContext()).load(Const.IMG_URL + details.getBackdrop_path()).into(movieDetailsImageView);
                Glide.with(getContext()).load(Const.IMG_URL + details.getPoster_path()).into(movieDetailsPosterImageView);
                StringBuilder genreToSet = new StringBuilder();
                for (int i = 0; i < details.getGenres().size(); i++) {
                    if (i != details.getGenres().size() - 1) {
                        genreToSet.append(details.getGenres().get(i).getName() + ", ");
                    } else {
                        genreToSet.append(details.getGenres().get(i).getName());
                    }
                }
                movieDetailsGenresTextView.setText(genreToSet);

                movieDetailsProductionCompaniesRecyclerView.setAdapter(new ProductionCompaniesAdapter(getContext(), details.getProduction_companies()));
                movieDetailsProductionCompaniesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

                isDetailsLoaded = true;

                if (isCreditsLoaded) {
                    movieDetailsImageView.setVisibility(View.VISIBLE);
                    movieDetailsStarImageView.setVisibility(View.VISIBLE);
                    movieDetailsPosterImageView.setVisibility(View.VISIBLE);
                    movieDetailsTextView.setVisibility(View.VISIBLE);
                    movieDetailsTextView2.setVisibility(View.VISIBLE);
                    movieDetailsTextView3.setVisibility(View.VISIBLE);
                    movieDetailsTextView5.setVisibility(View.VISIBLE);
                    movieDetailsTextView6.setVisibility(View.VISIBLE);
                    movieDetailsTitleTextView.setVisibility(View.VISIBLE);
                    movieDetailsTaglineTextView.setVisibility(View.VISIBLE);
                    movieDetailsReleaseDateTextView.setVisibility(View.VISIBLE);
                    movieDetailsVoteAverageTextView.setVisibility(View.VISIBLE);
                    movieDetailsOverviewTextView.setVisibility(View.VISIBLE);
                    movieDetailsGenresTextView.setVisibility(View.VISIBLE);
                    movieDetailsFullReleaseDateTextView.setVisibility(View.VISIBLE);
                    movieDetailsProductionCompaniesRecyclerView.setVisibility(View.VISIBLE);
                    movieDetailsCastsRecyclerView.setVisibility(View.VISIBLE);;
                    movieDetailsCrewRecyclerView.setVisibility(View.VISIBLE);
                    movieDetailsProgressBar.setVisibility(View.GONE);
                }
            }
        });

        movieViewModel.getCredits(movieId);
        movieViewModel.getCreditsResult().observe(getViewLifecycleOwner(), new Observer<Movie.Credits>() {
            @Override
            public void onChanged(Movie.Credits credits) {
                movieDetailsCastsRecyclerView.setAdapter(new CastsAdapter(getContext(), credits.getCast()));
                movieDetailsCastsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

                movieDetailsCrewRecyclerView.setAdapter(new CrewAdapter(getContext(), credits.getCrew()));
                movieDetailsCrewRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

                isCreditsLoaded = true;

                if (isDetailsLoaded) {
                    movieDetailsImageView.setVisibility(View.VISIBLE);
                    movieDetailsStarImageView.setVisibility(View.VISIBLE);
                    movieDetailsPosterImageView.setVisibility(View.VISIBLE);
                    movieDetailsTextView.setVisibility(View.VISIBLE);
                    movieDetailsTextView2.setVisibility(View.VISIBLE);
                    movieDetailsTextView3.setVisibility(View.VISIBLE);
                    movieDetailsTextView5.setVisibility(View.VISIBLE);
                    movieDetailsTextView6.setVisibility(View.VISIBLE);
                    movieDetailsTitleTextView.setVisibility(View.VISIBLE);
                    movieDetailsTaglineTextView.setVisibility(View.VISIBLE);
                    movieDetailsReleaseDateTextView.setVisibility(View.VISIBLE);
                    movieDetailsVoteAverageTextView.setVisibility(View.VISIBLE);
                    movieDetailsOverviewTextView.setVisibility(View.VISIBLE);
                    movieDetailsGenresTextView.setVisibility(View.VISIBLE);
                    movieDetailsFullReleaseDateTextView.setVisibility(View.VISIBLE);
                    movieDetailsProductionCompaniesRecyclerView.setVisibility(View.VISIBLE);
                    movieDetailsCastsRecyclerView.setVisibility(View.VISIBLE);;
                    movieDetailsCrewRecyclerView.setVisibility(View.VISIBLE);
                    movieDetailsProgressBar.setVisibility(View.GONE);
                }
            }
        });

        movieDetailsBackImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).popBackStack();
            }
        });

        return view;
    }
}