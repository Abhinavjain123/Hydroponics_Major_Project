package com.example.hydroponics_major_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class read_data extends AppCompatActivity {
    private DatabaseReference humidName;
    private DatabaseReference tempName;
    private DatabaseReference phName;
    private DatabaseReference waterName;
    private TextView textHumid;
    private TextView textTemp;
    private TextView textPh;
    private TextView textWater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data);
        textHumid=findViewById(R.id.HumidText);
        textTemp=findViewById(R.id.TextTemp);
        textPh=findViewById(R.id.TextPH);
        textWater=findViewById(R.id.TextWater);
        humidName= FirebaseDatabase.getInstance().getReference("Sensor").child("humid");
        tempName= FirebaseDatabase.getInstance().getReference("Sensor").child("temp");
        phName= FirebaseDatabase.getInstance().getReference("Sensor").child("ph");
        waterName= FirebaseDatabase.getInstance().getReference("Sensor").child("water_value");
        humidName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    String data=snapshot.getValue().toString();
                    textHumid.setText(data);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        tempName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String data=snapshot.getValue().toString();
                textTemp.setText(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//
        phName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String data=snapshot.getValue().toString();
                textPh.setText(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        waterName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String data=snapshot.getValue().toString();
                textWater.setText(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}