package com.mastercoding.movieapp.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mastercoding.movieapp.Models.MovieModel;
import com.mastercoding.movieapp.request.MovieApiClient;

import java.util.List;

public class MovieRepository {

    // This Class is acting as repositories

    private static MovieRepository instance;

    private MovieApiClient movieApiClient;


    private static MovieRepository getInstance() {
        if (instance == null) {
            instance = new MovieRepository();
        }
        return instance;
    }

    private MovieRepository() {
        movieApiClient = MovieApiClient.getInstance();

    }

    public LiveData<List<MovieModel>> getMovies() {
        return movieApiClient.getMovies();

    }

}
