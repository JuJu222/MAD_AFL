package com.example.moviedbafl.api;

import com.example.moviedbafl.models.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndPoint {

    @GET("movie/{movie_id}")
    Call<Movie.Details> getDetails(
            @Path("movie_id") int movieId,
            @Query("api_key") String apiKey
    );

    @GET("movie/now_playing")
    Call<Movie.NowPlayingUpcoming> getNowPLaying(
            @Query("page") int page,
            @Query("api_key") String apiKey
    );

    @GET("movie/upcoming")
    Call<Movie.NowPlayingUpcoming> getUpcoming(
            @Query("page") int page,
            @Query("api_key") String apiKey
    );

    @GET("movie/{movie_id}/credits")
    Call<Movie.Credits> getCredits(
            @Path("movie_id") int movieId,
            @Query("api_key") String apiKey
    );
}
