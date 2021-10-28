package com.example.moviedbafl.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.moviedbafl.helpers.Const;
import com.example.moviedbafl.models.Movie;
import com.example.moviedbafl.api.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private static MovieRepository repository;

    private MovieRepository() {

    }

    public static MovieRepository getInstance() {
        if (repository == null) {
            repository = new MovieRepository();
        }
        return repository;
    }

    public MutableLiveData<Movie.Details> getDetails(int movieId) {
        final MutableLiveData<Movie.Details> result = new MutableLiveData<>();

        ApiService.endpoint().getDetails(movieId, Const.API_KEY).enqueue(new Callback<Movie.Details>() {
            @Override
            public void onResponse(Call<Movie.Details> call, Response<Movie.Details> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Movie.Details> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return result;
    }

    private List<Movie.NowPlayingUpcoming.Results> nowPlayingList = new ArrayList<>();
    public MutableLiveData<List<Movie.NowPlayingUpcoming.Results>> getNowPlaying(int page) {
        final MutableLiveData<List<Movie.NowPlayingUpcoming.Results>> result = new MutableLiveData<>();

        ApiService.endpoint().getNowPLaying(page, Const.API_KEY).enqueue(new Callback<Movie.NowPlayingUpcoming>() {
            @Override
            public void onResponse(Call<Movie.NowPlayingUpcoming> call, Response<Movie.NowPlayingUpcoming> response) {
                nowPlayingList.addAll(response.body().getResults());
                result.setValue(nowPlayingList);
            }

            @Override
            public void onFailure(Call<Movie.NowPlayingUpcoming> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return result;
    }
    public void clearNowPlayingList() {
        nowPlayingList.clear();
    }

    private List<Movie.NowPlayingUpcoming.Results> upcomingList = new ArrayList<>();
    public MutableLiveData<List<Movie.NowPlayingUpcoming.Results>> getUpcoming(int page) {
        final MutableLiveData<List<Movie.NowPlayingUpcoming.Results>> result = new MutableLiveData<>();

        ApiService.endpoint().getUpcoming(page, Const.API_KEY).enqueue(new Callback<Movie.NowPlayingUpcoming>() {
            @Override
            public void onResponse(Call<Movie.NowPlayingUpcoming> call, Response<Movie.NowPlayingUpcoming> response) {
                upcomingList.addAll(response.body().getResults());
                result.setValue(upcomingList);
            }

            @Override
            public void onFailure(Call<Movie.NowPlayingUpcoming> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return result;
    }
    public void clearUpcomingList() {
        upcomingList.clear();
    }

    public MutableLiveData<Movie.Credits> getCredits(int movieId) {
        final MutableLiveData<Movie.Credits> result = new MutableLiveData<>();

        ApiService.endpoint().getCredits(movieId, Const.API_KEY).enqueue(new Callback<Movie.Credits>() {
            @Override
            public void onResponse(Call<Movie.Credits> call, Response<Movie.Credits> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Movie.Credits> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return result;
    }
}
