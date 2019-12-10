package com.example.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("top-headlines")
    Call<ModelList> getData(
            @Query("sources") String sources,
            @Query("apiKey") String apiKey

    );
}
