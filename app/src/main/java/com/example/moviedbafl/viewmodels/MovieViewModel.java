package com.example.moviedbafl.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.moviedbafl.models.Movie;
import com.example.moviedbafl.repositories.MovieRepository;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {
    private MovieRepository repository;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        repository = MovieRepository.getInstance();
    }

    private MutableLiveData<Movie.Details> details = new MutableLiveData<>();
    public void getDetails(int movieId) {
        details = repository.getDetails(movieId);
    }
    public LiveData<Movie.Details> getDetailsResult() {
        return details;
    }

    private MutableLiveData<List<Movie.NowPlayingUpcoming.Results>> nowPlaying = new MutableLiveData<>();
    public void getNowPlaying(int page){
        nowPlaying = repository.getNowPlaying(page);
    }
    public LiveData<List<Movie.NowPlayingUpcoming.Results>> getNowPlayingResult(){
        return nowPlaying;
    }
    public void clearNowPlayingList() {
        repository.clearNowPlayingList();
    }

    private MutableLiveData<List<Movie.NowPlayingUpcoming.Results>> upcoming = new MutableLiveData<>();
    public void getUpcoming(int page) {
        upcoming = repository.getUpcoming(page);
    }
    public LiveData<List<Movie.NowPlayingUpcoming.Results>> getUpcomingResult(){
        return upcoming;
    }
    public void clearUpcomingList() {
        repository.clearUpcomingList();
    }

    private MutableLiveData<Movie.Credits> credits = new MutableLiveData<>();
    public void getCredits(int movieId) {
        credits = repository.getCredits(movieId);
    }
    public LiveData<Movie.Credits> getCreditsResult() {
        return credits;
    }
}
