package com.example.hydroponics_major_project;

import android.content.Intent;
import android.os.AsyncTask;
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

import java.text.DecimalFormat;

public class LiveStatus extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.crop_live_statue);
//        String cropName = getIntent().getStringExtra("cropName");

//
//        TextView cropNameTextView = (TextView) findViewById(R.id.cropNameTextView);
//        cropNameTextView.setText(cropName);
//

//
//        ThingspeakClient client = new ThingspeakClient();
//        AsyncTask<String, String, String> a = client.execute("https://api.thingspeak.com/channels/2080835/feeds.json?api_key=SPJO1DKYA6LX64QW&results=1");
//        System.out.println(a);

    private DatabaseReference humidName;
    private DatabaseReference cropName;
    private DatabaseReference lightName;
    private DatabaseReference nutrientName;
    private DatabaseReference tempName;
    private DatabaseReference phName;
    private DatabaseReference waterName;
    private TextView textHumid;
    private TextView textTemp;
    private TextView textPh;
    private TextView textWater;
    private TextView textLight;
    private TextView textNutrient;
    private TextView textCrop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crop_live_statue);
        DecimalFormat df = new DecimalFormat("0.00");
        df.setMaximumFractionDigits(2);
        textHumid=findViewById(R.id.rhTextView);
        textTemp=findViewById(R.id.tempTextView);
        textPh=findViewById(R.id.phTextView);
        textWater=findViewById(R.id.waterLevelTextView);
        //textLight=findViewById(R.id.lightTextView);
        //textCrop=findViewById(R.id.cropNameTextView);
        textNutrient=findViewById(R.id.nutrientTextView);
        //humidName= FirebaseDatabase.getInstance().getReference("Puneet").child("humid");
        //lightName= FirebaseDatabase.getInstance().getReference("Sensor").child("light");
        //cropName= FirebaseDatabase.getInstance().getReference("Sensor").child("cropName");
        nutrientName= FirebaseDatabase.getInstance().getReference("Puneet").child("nutrients");
        humidName= FirebaseDatabase.getInstance().getReference("Puneet").child("humidity");
        tempName= FirebaseDatabase.getInstance().getReference("Puneet").child("temp");
        phName= FirebaseDatabase.getInstance().getReference("Puneet").child("ph");
        waterName= FirebaseDatabase.getInstance().getReference("Puneet").child("water_level");

        Button backButton = (Button) findViewById(R.id.live_status_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        humidName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    String data=df.format(Float.parseFloat(snapshot.getValue().toString()));;
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
                String data=df.format(Float.parseFloat(snapshot.getValue().toString()));;
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
                String data=df.format(Float.parseFloat(snapshot.getValue().toString()));;
                textPh.setText(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        waterName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String data=df.format(Float.parseFloat(snapshot.getValue().toString()));;
                textWater.setText(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//        cropName.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.exists())
//                {
//                    String data=snapshot.getValue().toString();
//                    textCrop.setText(data);
//                }
//            }

//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//        lightName.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.exists())
//                {
//                    String data=snapshot.getValue().toString();
//                    textLight.setText(data);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
        nutrientName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    String data=df.format(Float.parseFloat(snapshot.getValue().toString()));;
                    textNutrient.setText(data);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}