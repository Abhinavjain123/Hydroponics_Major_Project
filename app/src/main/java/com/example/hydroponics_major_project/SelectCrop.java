package com.example.hydroponics_major_project;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
public class SelectCrop extends AppCompatActivity {

    FloatingActionButton addButton;
    Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_crop);

        addButton = (FloatingActionButton) findViewById(R.id.add_button);
        nextButton = (Button) findViewById(R.id.nextButton);
        addButton.setOnClickListener(new View.OnClickListener() {   
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AddCrop.class);
                startActivity(i);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SetParameters.class);
                startActivity(i);
            }
        });
    }
}
