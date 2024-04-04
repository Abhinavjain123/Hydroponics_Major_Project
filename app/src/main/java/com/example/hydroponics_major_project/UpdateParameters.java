package com.example.hydroponics_major_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.text.DecimalFormat;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateParameters extends AppCompatActivity {
    private DatabaseReference minTemp;
    private DatabaseReference maxTemp;
    private DatabaseReference minPh;
    private DatabaseReference maxPh;
    private DatabaseReference minNutrient;
    private DatabaseReference maxNutrient;
    private DatabaseReference lightDuration;
    private DatabaseReference minHumidity;
//    private DatabaseReference nutrients;
    private EditText textMinTemp;
    private EditText textMaxTemp;
    private EditText textMinPh;
    private EditText textMaxPh;
    private EditText textMinRh;
    private EditText textMaxRh;
    private EditText textMinHumidity;
    private EditText textLightDuration;
//    private EditText textNutrients;
    private Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_parameters);
        DecimalFormat df = new DecimalFormat("0.00");
        df.setMaximumFractionDigits(2);
        textMaxTemp=findViewById(R.id.maxTemp);
        textMinTemp=findViewById(R.id.minTemp);
        textMaxPh=findViewById(R.id.maxPh);
        textMinPh=findViewById(R.id.minPh);
        textMaxRh=findViewById(R.id.maxNutrient);
        textMinRh=findViewById(R.id.minNutrient);
        textLightDuration=findViewById(R.id.lightDuration);
        textMinHumidity=findViewById(R.id.minHumidity);
//        textNutrients=findViewById(R.id.nutrients);
        update=findViewById(R.id.update);
        maxTemp= FirebaseDatabase.getInstance().getReference("Puneet").child("maxTemp");
        minTemp= FirebaseDatabase.getInstance().getReference("Puneet").child("minTemp");
        maxPh= FirebaseDatabase.getInstance().getReference("Puneet").child("maxPh");
        minPh= FirebaseDatabase.getInstance().getReference("Puneet").child("minPh");
        maxNutrient= FirebaseDatabase.getInstance().getReference("Puneet").child("maxNutrient");
        minNutrient= FirebaseDatabase.getInstance().getReference("Puneet").child("minNutrient");
        lightDuration= FirebaseDatabase.getInstance().getReference("Puneet").child("lightDuration");
        minHumidity= FirebaseDatabase.getInstance().getReference("Puneet").child("minHumidity");
//        nutrients= FirebaseDatabase.getInstance().getReference("Puneet").child("nutrients");
//
        maxTemp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    String data=df.format(Float.parseFloat(snapshot.getValue().toString()));
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
                if(snapshot.exists()){
                    String data=df.format(Float.parseFloat(snapshot.getValue().toString()));
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
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float Temp1=Float.parseFloat(textMaxTemp.getText().toString());
                Float Temp2=Float.parseFloat(textMinTemp.getText().toString());
                Float ph1=Float.parseFloat(textMaxPh.getText().toString());
                Float ph2=Float.parseFloat(textMinPh.getText().toString());
                Float rh1=Float.parseFloat(textMaxRh.getText().toString());
                Float rh2=Float.parseFloat(textMinRh.getText().toString());
                Float light=Float.parseFloat(textLightDuration.getText().toString());
                Float humidity=Float.parseFloat(textMinHumidity.getText().toString());
//                Float nutrie=Float.parseFloat(textNutrients.getText().toString());
                 maxTemp.setValue(Temp1);
                 minTemp.setValue(Temp2);
                 maxPh.setValue(ph1);
                 minPh.setValue(ph2);
                 maxNutrient.setValue(rh1);
                 minNutrient.setValue(rh2);
                 lightDuration.setValue(light);
                 minHumidity.setValue(humidity);
//                 nutrients.setValue(nutrie);
                Intent i = new Intent(getApplicationContext(), SetParameters.class);
                startActivity(i);
            }
        });
    }
}