package com.example.testproject.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testproject.model.TypiCodeModel;
import com.example.testproject.network.ApiCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsViewModel extends ViewModel {
    private MutableLiveData<List<TypiCodeModel>> newsList;

    public LiveData<List<TypiCodeModel>> getNews() {
        if (newsList == null) {
            newsList = new MutableLiveData<>();
            loadNews();
        }
        return newsList;
    }

    private void loadNews() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiCallback.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        ApiCallback api = retrofit.create(ApiCallback.class);
        Call<List<TypiCodeModel>> call = api.getNews();

        call.enqueue(new Callback<List<TypiCodeModel>>() {
            @Override
            public void onResponse(Call<List<TypiCodeModel>> call, Response<List<TypiCodeModel>> response) {
                assert response.body() != null;
                if (response.isSuccessful()) {
                    newsList.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<TypiCodeModel>> call, Throwable t) {
                Log.i("NewsViewModel", t.toString());
            }
        });
    }

}



