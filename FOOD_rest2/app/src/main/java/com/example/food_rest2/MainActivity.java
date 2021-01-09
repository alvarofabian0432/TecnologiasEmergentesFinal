package com.example.food_rest2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.food_rest2.model.Platillo;
import com.example.food_rest2.retrofit.ApiInterface;
import com.example.food_rest2.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;

    RecyclerView desayunoRecyclerView;

    DesayunosAdapter desayunosAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        
        Call<List<Platillo>> call = apiInterface.getAllData();
        call.enqueue(new Callback<List<Platillo>>() {
            @Override
            public void onResponse(Call<List<Platillo>> call, Response<List<Platillo>> response) {

                List<Platillo> platoDataList = response.body();

                getDesayunoData(platoDataList.get(0).getPlatillos());

            }

            @Override
            public void onFailure(Call<List<Platillo>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"El servidor no está respondiendo", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void getDesayunoData(List<Platillo> desayunosList){

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando datos...");
        progressDialog.show();

        desayunoRecyclerView = findViewById(R.id.popular_recycler);
        desayunosAdapter = new DesayunosAdapter(this, desayunosList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        desayunoRecyclerView.setLayoutManager(layoutManager);
        desayunoRecyclerView.setAdapter(desayunosAdapter);
    }
}