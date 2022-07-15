 package com.mastercoding.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mastercoding.movieapp.Models.MovieModel;
import com.mastercoding.movieapp.Utils.Credentials;
import com.mastercoding.movieapp.Utils.MovieApi;
import com.mastercoding.movieapp.request.Servicey;
import com.mastercoding.movieapp.response.MovieSearchResponse;
import com.mastercoding.movieapp.viewModels.MovieListViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

 public abstract class MovieListActivity extends AppCompatActivity {


    Button btn;
    // ViewModel
     private MovieListViewModel movieListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);

        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);

    }

    // observing any data change
     private void ObserveAnychange(){
        movieListViewModel.getMovies().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {

                // Observing for nay data change

            }
        });
     }
     private void GetRetrofitResponse() {

      MovieApi movieApi = Servicey.getMovieApi();

         Call<MovieSearchResponse> responseCall = movieApi.
                 searchMovie(
                         Credentials.API_KEY,
                         "Minions: The Rise of Gru",
                         "1");

         responseCall.enqueue(new Callback<MovieSearchResponse>() {
             @Override
             public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                 if(response.code() == 200){

                     Log.v("Tag","the response " +response.body().toString());
                     List<MovieModel> movies = new ArrayList<>(response.body().getMovies());

                     for(MovieModel movie : movies){
                         Log.v("Tag", "The Release date " +movie.getRelease_date());
                     }

                 }
                 else{
                     try {
                         Log.v("Tag","Error" +response.errorBody().string());
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
             }

             @Override
             public void onFailure(Call<MovieSearchResponse> call, Throwable t) {

             }
         });


     }

    private void GetRetrofitResponseAccordingToID(){


        MovieApi movieApi = Servicey.getMovieApi();
        Call<MovieModel> responseCall = movieApi
                .getMovie(550,Credentials.API_KEY);

        responseCall.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {

                if(response.code() == 200){
                    MovieModel movie = response.body();

                    Log.v("Tag", "The Response" +movie.getTitle());
                }

                else{
                    try{
                        Log.v("Tag","Error" +response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });
    }

     }



