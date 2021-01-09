package com.example.food_spring.Utils;

import com.example.food_spring.Model.Platillo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlatilloService {

    @GET("listar/")
    Call<List<Platillo>> getDesayunos();
}
