package com.mastercoding.movieapp.Utils;

import com.mastercoding.movieapp.Models.MovieModel;
import com.mastercoding.movieapp.response.MovieSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {

    // Search for movies
    @GET
    Call<MovieSearchResponse> searchMovie(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") String page
    );

// Making search with ID
    // https://api.themoviedb.org/3/movie/550?api_key=79faaaa4592ef5d4279c97d15316ccb0
    // Remember that movie_id = 550 is for

    @GET("3/movie/{movie_id}?")
    Call<MovieModel> getMovie(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key);

}
