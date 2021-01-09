package com.example.food_rest2.retrofit;

import com.example.food_rest2.model.Platillo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("v1/platillos")
    Call<List<Platillo>> getAllData();
}
