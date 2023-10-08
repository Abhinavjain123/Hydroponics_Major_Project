package com.example.hydroponics_major_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button homeButton, liveButton, currentButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeButton = (Button) findViewById(R.id.homeButton);
        liveButton = (Button) findViewById(R.id.liveButton);
        currentButton=(Button) findViewById(R.id.button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SelectCrop.class);
                startActivity(i);
            }
        });

        liveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ScrollActivity.class);
                startActivity(i);
            }
        });

        currentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), read_data.class);
                startActivity(i);
            }
        });
        ThingspeakClient client = new ThingspeakClient();
        client.execute("https://api.thingspeak.com/channels/2080835/feeds.json?api_key=SPJO1DKYA6LX64QW&results=3");
    }
}