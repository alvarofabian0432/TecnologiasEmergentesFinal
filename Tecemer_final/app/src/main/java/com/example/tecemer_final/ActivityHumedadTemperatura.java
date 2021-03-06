package com.example.tecemer_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ActivityHumedadTemperatura extends AppCompatActivity {

    private TextView hume;
    private TextView tempe;

    private MaterialButton btnIntentLeds;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humedad_temperatura);

        btnIntentLeds = findViewById(R.id.btnIntentLeds);
        hume = findViewById(R.id.lblHumed);
        tempe = findViewById(R.id.lblTempe);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("Sensor").child("hum");
        DatabaseReference myRef2 = database.getReference().child("Sensor").child("temp");

        btnIntentLeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityHumedadTemperatura.this, ActivityLeds.class);
                startActivity(intent);
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                hume.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String te = snapshot.getValue(String.class);
                tempe.setText(te);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}