package com.mastercoding.movieapp.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mastercoding.movieapp.Models.MovieModel;

import java.util.List;

public class MovieRepository {

    // This Class is acting as repositories

    private static MovieRepository instance;

    // LiveData
    private MutableLiveData<List<MovieModel>> mMovies;

    private static MovieRepository getInstance(){
        if(instance == null){
            instance = new MovieRepository();
        }
        return instance;
    }

    private MovieRepository(){
        mMovies  = new MutableLiveData<>();

    }
    public LiveData<List<MovieModel>> getMovies(){
        return mMovies;

    }

}
