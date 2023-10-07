package com.example.hydroponics_major_project;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LiveStatus extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crop_live_statue);
        String cropName = getIntent().getStringExtra("cropName");

        TextView cropNameTextView = (TextView) findViewById(R.id.cropNameTextView);
        cropNameTextView.setText(cropName);

        ThingspeakClient client = new ThingspeakClient();
        AsyncTask<String, String, String> a = client.execute("https://api.thingspeak.com/channels/2080835/feeds.json?api_key=SPJO1DKYA6LX64QW&results=1");
        System.out.println(a);
    }
}