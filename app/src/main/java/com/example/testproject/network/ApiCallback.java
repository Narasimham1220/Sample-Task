package com.example.testproject.network;

import com.example.testproject.model.TypiCodeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiCallback {

    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("photos")
    Call<List<TypiCodeModel>> getNews();


}
