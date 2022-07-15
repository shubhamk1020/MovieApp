package com.mastercoding.movieapp.viewModels;

import android.graphics.Movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mastercoding.movieapp.Models.MovieModel;

import java.util.List;

public class MovieListViewModel extends ViewModel {

    //  this class is used for VIEWMODEL

    // LiveData
    private MutableLiveData<List<MovieModel>> mMovies = new MutableLiveData<>();

    public MovieListViewModel(){

    }
    public LiveData<List<MovieModel>> getMovies (){
        return mMovies;
    }
}
