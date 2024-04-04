package com.example.hydroponics_major_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SetParameters extends AppCompatActivity{
    private DatabaseReference minTemp;
    private DatabaseReference maxTemp;
    private DatabaseReference minPh;
    private DatabaseReference maxPh;
    private DatabaseReference minNutrient;
    private DatabaseReference maxNutrient;
    private DatabaseReference lightDuration;
    private DatabaseReference minHumidity;
//    private DatabaseReference nutrients;
    private TextView textMinTemp;
    private TextView textMaxTemp;
    private TextView textMinPh;
    private TextView textMaxPh;
    private TextView textMinRh;
    private TextView textMaxRh;
    private TextView textLightDuration;
    private TextView textMinHumidity;
//    private TextView textNutrients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_parameters);
        DecimalFormat df = new DecimalFormat("0.00");
        df.setMaximumFractionDigits(2);
        textMaxTemp=findViewById(R.id.maxTemp);
        textMinTemp=findViewById(R.id.minTemp);
        textMaxPh=findViewById(R.id.maxPh);
        textMinPh=findViewById(R.id.minPh);
        textMaxRh=findViewById(R.id.maxRh);
        textMinRh=findViewById(R.id.minRh);
        textLightDuration=findViewById(R.id.lightDuration);
        textMinHumidity=findViewById(R.id.minHumidity);
//        textNutrients=findViewById(R.id.nutrients);
        maxTemp= FirebaseDatabase.getInstance().getReference("Puneet").child("maxTemp");
        minTemp= FirebaseDatabase.getInstance().getReference("Puneet").child("minTemp");
        maxPh= FirebaseDatabase.getInstance().getReference("Puneet").child("maxPh");
        minPh= FirebaseDatabase.getInstance().getReference("Puneet").child("minPh");
        maxNutrient= FirebaseDatabase.getInstance().getReference("Puneet").child("maxNutrient");
        minNutrient= FirebaseDatabase.getInstance().getReference("Puneet").child("minNutrient");
        lightDuration= FirebaseDatabase.getInstance().getReference("Puneet").child("lightDuration");
        minHumidity=FirebaseDatabase.getInstance().getReference("Puneet").child("minHumidity");
//        nutrients= FirebaseDatabase.getInstance().getReference("Puneet").child("nutrients");
        maxTemp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    String data=df.format(Float.parseFloat(snapshot.getValue().toString()));
                    data=data+" \u2103";
                    textMaxTemp.setText(data);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        minTemp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    String data=df.format(Float.parseFloat(snapshot.getValue().toString()));
                    data=data+" \u2103";
                    textMinTemp.setText(data);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        maxPh.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    String data=df.format(Float.parseFloat(snapshot.getValue().toString()));
                    data=data+" ph";
                    textMaxPh.setText(data);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        minPh.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    String data=df.format(Float.parseFloat(snapshot.getValue().toString()));
                    data=data+" ph";
                    textMinPh.setText(data);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        maxNutrient.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    String data=df.format(Float.parseFloat(snapshot.getValue().toString()));
                    data=data+" ppm";
                    textMaxRh.setText(data);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        minNutrient.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    String data=df.format(Float.parseFloat(snapshot.getValue().toString()));
                    data=data+" ppm";
                    textMinRh.setText(data);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        lightDuration.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    String data=df.format(Float.parseFloat(snapshot.getValue().toString()));
                    data=data+" hrs";
                    textLightDuration.setText(data);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        minHumidity.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    String data=df.format(Float.parseFloat(snapshot.getValue().toString()));
                    data=data+" %";
                    textMinHumidity.setText(data);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        nutrients.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.exists())
//                {
//                    String data=df.format(Float.parseFloat(snapshot.getValue().toString()));
//                    textNutrients.setText(data);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        Button updateButton = (Button) findViewById(R.id.update_parameters);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), UpdateParameters.class);
                startActivity(i);
            }
        });
    }
}
