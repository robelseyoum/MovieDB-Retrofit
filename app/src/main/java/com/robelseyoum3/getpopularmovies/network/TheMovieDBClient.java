package com.robelseyoum3.getpopularmovies.network;

import com.robelseyoum3.getpopularmovies.model.MovieDBModel;
import com.robelseyoum3.getpopularmovies.model.MovieDetials.Details;
import com.robelseyoum3.getpopularmovies.model.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TheMovieDBClient {


    //@GET("/movie/top_rated/{api_key}") //{api_key} is a placeholder

//    @GET("/movie/popular/{api_key}")
//    Call<List<MovieDBModel>> getTopMovies(@Path("api_key") String api_key);

    @GET("movie/popular")
    Call<MovieDBModel> getTopMovies(@Query("api_key") String userkey);

//    @GET("movie/popular")
//    Call<Details> getTopDetailes(@Query("api_key") String userkey);




    //    Call<MovieDBModel> getTopMovies(@Query("page") int page, @Query("api_key") String userkey);

    //here used to dynamically assign the user name


}
