package com.robelseyoum3.getpopularmovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.robelseyoum3.getpopularmovies.model.MovieDBModel;
import com.robelseyoum3.getpopularmovies.model.Result;
import com.robelseyoum3.getpopularmovies.network.RetrofitInstances;
import com.robelseyoum3.getpopularmovies.network.TheMovieDBClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView mrecyclerView;
    private MovieAdaptor movieAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TheMovieDBClient getTopMoviesList = RetrofitInstances.getRetrofitInstances().create(TheMovieDBClient.class);

        Call<MovieDBModel> call = getTopMoviesList.getTopMovies("8a94a224123587673557e8c4ba8c813c");

        call.enqueue(new Callback<MovieDBModel>() {

            @Override
            public void onResponse(Call<MovieDBModel> call, Response<MovieDBModel> response) {

                MovieDBModel movieDBModel = response.body();

                Log.i("Message", "Movie Title: "+movieDBModel.getResults().get(0).getTitle());

                if(movieDBModel != null){
                    generateMovieData(movieDBModel);
                    Log.i("Message", "Movie Image Path : "+movieDBModel.getResults().get(0).getPosterPath());
                }else
                    {
                    Log.i("ERRROR - Message", "ERROR ERROR ERROR");

                }
            }

            @Override
            public void onFailure(Call<MovieDBModel> call, Throwable t) {

            }
        });

    }

    private void generateMovieData(final MovieDBModel movieDBModel){
        mrecyclerView = findViewById(R.id.recyler_view_list);


        movieAdaptor = new MovieAdaptor(movieDBModel, new MovieAdaptor.onMovieClickListener() {
            @Override
            public void onMovieClicked(int movieID) {
              Toast.makeText(MainActivity.this,"ID of this movie is: "+movieID,Toast.LENGTH_SHORT).show();



            }
        });

        //here we create to design the values
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mrecyclerView.setLayoutManager(layoutManager);

        //here we bind the activity_main recyclerView with the objects into personAdapter
        mrecyclerView.setAdapter(movieAdaptor);


    }
}
