package com.example.hydroponics_major_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.nio.charset.StandardCharsets;

public class BluetoothHandler extends AppCompatActivity {
    Button enterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bluetooth);
        enterButton = findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((BluetoothApplication)getApplication()).writeBt("Hello World\n".getBytes(StandardCharsets.UTF_8))){
                    Toast.makeText(getApplicationContext(), "OK, sent", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "ESP not connected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}