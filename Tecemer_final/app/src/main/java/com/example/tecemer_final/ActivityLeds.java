package com.example.tecemer_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.tecemer_final.model.Leds;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ActivityLeds extends AppCompatActivity {

    private ImageView imgLed1, imgLed2, imgLed3;
    private Button btnOn1, btnOn2, btnOff1, btnOff2;
    private Leds leds;
    private MaterialButton btnIntentTemperaturaHumedad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leds);

        btnIntentTemperaturaHumedad = findViewById(R.id.btnIntentTemperaturaHumedad);

        imgLed1 = findViewById(R.id.imgLed1);
        imgLed2 = findViewById(R.id.imgLed2);

        btnOn1 = findViewById(R.id.btnon1);
        btnOn2 = findViewById(R.id.btnon2);

        btnOff1 = findViewById(R.id.btnoff1);
        btnOff2 = findViewById(R.id.btnoff2);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Leds");

        btnIntentTemperaturaHumedad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLeds.this, ActivityHumedadTemperatura.class);
                startActivity(intent);
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                leds = snapshot.getValue(Leds.class);

                if (leds.led1.equals("1")) {
                    imgLed1.setImageResource(R.drawable.led_on);
                } else {
                    imgLed1.setImageResource(R.drawable.led_off);
                }

                if (leds.led2.equals("1")) {
                    imgLed2.setImageResource(R.drawable.led_on);
                } else {
                    imgLed2.setImageResource(R.drawable.led_off);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Enviar mensaje de error
            }
        });

        //Comandos para el primer led
        btnOn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leds.led1 = "1";
                myRef.setValue(leds);
            }
        });
        btnOff1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leds.led1 = "0";
                myRef.setValue(leds);
            }
        });

        //Comandos para el segundo led
        btnOn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leds.led2 = "1";
                myRef.setValue(leds);
            }
        });
        btnOff2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leds.led2 = "0";
                myRef.setValue(leds);
            }
        });
    }
}