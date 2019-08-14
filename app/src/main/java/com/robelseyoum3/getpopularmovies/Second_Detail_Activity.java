package com.robelseyoum3.getpopularmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.robelseyoum3.getpopularmovies.model.MovieDBModel;
import com.robelseyoum3.getpopularmovies.model.MovieDetials.Details;
import com.robelseyoum3.getpopularmovies.network.RetrofitInstances;
import com.robelseyoum3.getpopularmovies.network.TheMovieDBClient;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Second_Detail_Activity extends AppCompatActivity {

    private TextView tvTitle, tvOverView;
    private ImageView imageView;

    public static final String Movie_ID= "Movie_ID";
    private ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__detail_);

        tvTitle = findViewById(R.id.tv_title);
        tvOverView = findViewById(R.id.tv_overview);
        imageView = findViewById(R.id.tv_image);


        progressBar = findViewById(R.id.progress_id);
        progressBar.setVisibility(View.VISIBLE);

        String movie_id = getIntent().getStringExtra(Movie_ID);

        TheMovieDBClient getMovieDetails = RetrofitInstances.getRetrofitInstances().create(TheMovieDBClient.class);

        Call<Details> call = getMovieDetails.getTopDetailes(Integer.parseInt(movie_id), Constants.api_key);

        call.enqueue(new Callback<Details>() {
            @Override
            public void onResponse(Call<Details> call, Response<Details> response) {
                Details movieDetails = response.body();

                progressBar.setVisibility(View.GONE);

                tvTitle.setText(movieDetails.getTitle());
                tvOverView.setText(movieDetails.getOverview());
                Picasso.get().load("https://image.tmdb.org/t/p/w500"+movieDetails.getBackdropPath()).into(imageView);

            }

            @Override
            public void onFailure(Call<Details> call, Throwable t) {

            }
        });


    }
}
