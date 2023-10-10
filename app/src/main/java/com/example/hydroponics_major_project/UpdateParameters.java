package com.example.hydroponics_major_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateParameters extends AppCompatActivity {
    private DatabaseReference minTemp;
    private DatabaseReference maxTemp;
    private DatabaseReference minPh;
    private DatabaseReference maxPh;
    private DatabaseReference minRh;
    private DatabaseReference maxRh;
    private DatabaseReference lightDuration;
    private DatabaseReference nutrients;
    private EditText textMinTemp;
    private EditText textMaxTemp;
    private EditText textMinPh;
    private EditText textMaxPh;
    private EditText textMinRh;
    private EditText textMaxRh;
    private EditText textLightDuration;
    private EditText textNutrients;
    private Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_parameters);
        textMaxTemp=findViewById(R.id.maxTemp);
        textMinTemp=findViewById(R.id.minTemp);
        textMaxPh=findViewById(R.id.maxPh);
        textMinPh=findViewById(R.id.minPh);
        textMaxRh=findViewById(R.id.maxRh);
        textMinRh=findViewById(R.id.minRh);
        textLightDuration=findViewById(R.id.lightDuration);
        textNutrients=findViewById(R.id.nutrients);
        update=findViewById(R.id.update);
        maxTemp= FirebaseDatabase.getInstance().getReference("AndroidSensor").child("maxTemp");
        minTemp= FirebaseDatabase.getInstance().getReference("AndroidSensor").child("minTemp");
        maxPh= FirebaseDatabase.getInstance().getReference("AndroidSensor").child("maxPh");
        minPh= FirebaseDatabase.getInstance().getReference("AndroidSensor").child("minPh");
        maxRh= FirebaseDatabase.getInstance().getReference("AndroidSensor").child("maxRh");
        minRh= FirebaseDatabase.getInstance().getReference("AndroidSensor").child("minRh");
        lightDuration= FirebaseDatabase.getInstance().getReference("AndroidSensor").child("lightDuration");
        nutrients= FirebaseDatabase.getInstance().getReference("AndroidSensor").child("nutrients");
//
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
                Float nutrie=Float.parseFloat(textNutrients.getText().toString());
                 maxTemp.setValue(Temp1);
                 minTemp.setValue(Temp2);
                 maxPh.setValue(ph1);
                 minPh.setValue(ph2);
                 maxRh.setValue(rh1);
                 minRh.setValue(rh2);
                 lightDuration.setValue(light);
                 nutrients.setValue(nutrie);
                Intent i = new Intent(getApplicationContext(), SetParameters.class);
                startActivity(i);
            }
        });
    }
}