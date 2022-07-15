package com.mastercoding.movieapp.viewModels;



import androidx.lifecycle.LiveData;

import androidx.lifecycle.ViewModel;

import com.mastercoding.movieapp.Models.MovieModel;
import com.mastercoding.movieapp.repositories.MovieRepository;

import java.util.List;

public class MovieListViewModel extends ViewModel {

    //  this class is used for VIEWMODEL
    private MovieRepository movieRepository;
    // LiveData


    public MovieListViewModel(){

    }
    public LiveData<List<MovieModel>> getMovies (){
        return movieRepository.getMovies();
}
}
