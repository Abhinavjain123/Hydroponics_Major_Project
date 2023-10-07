package com.example.hydroponics_major_project;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LiveStatus extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crop_live_statue);
        String cropName = getIntent().getStringExtra("cropName");
        Button backButton = (Button) findViewById(R.id.live_status_back);

        TextView cropNameTextView = (TextView) findViewById(R.id.cropNameTextView);
        cropNameTextView.setText(cropName);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ScrollActivity.class);
                startActivity(i);
            }
        });

        ThingspeakClient client = new ThingspeakClient();
        AsyncTask<String, String, String> a = client.execute("https://api.thingspeak.com/channels/2080835/feeds.json?api_key=SPJO1DKYA6LX64QW&results=1");
        System.out.println(a);
    }
}