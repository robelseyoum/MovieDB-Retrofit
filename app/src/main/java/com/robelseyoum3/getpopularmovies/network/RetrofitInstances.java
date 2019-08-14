package com.robelseyoum3.getpopularmovies.network;

import com.robelseyoum3.getpopularmovies.Constants;
import com.robelseyoum3.getpopularmovies.model.MovieDBModel;

import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RetrofitInstances {

    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstances() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}