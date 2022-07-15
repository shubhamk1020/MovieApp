package com.mastercoding.movieapp.request;

import android.graphics.Movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mastercoding.movieapp.Models.MovieModel;

import java.util.List;

public class MovieApiClient {

    // LiveData
    private MutableLiveData<List<MovieModel>> mMovies;

    private static MovieApiClient instance;
    public static MovieApiClient getInstance(){
        if(instance == null){
            instance = new MovieApiClient();

        }
        return instance;
    }

    private MovieApiClient(){
        mMovies = new MutableLiveData<>();
    }

    public LiveData<List<MovieModel>> getMovies(){
        return mMovies;
    }

}
