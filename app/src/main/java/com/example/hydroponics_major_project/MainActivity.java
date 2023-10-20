package com.example.hydroponics_major_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Username = "username";
    public static final String Password = "password";
    Button homeButton, liveButton, currentButton, loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        currentButton=(Button) findViewById(R.id.button);

            setContentView(R.layout.activity_main);
            homeButton = (Button) findViewById(R.id.homeButton);
            liveButton = (Button) findViewById(R.id.liveButton);

            homeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), SetParameters.class);
                    startActivity(i);
                }
            });

            liveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), LiveStatus.class);
                    startActivity(i);
                }
            });


        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String uname = sharedpreferences.getString(Username, null);
        String password = sharedpreferences.getString(Password, null);
        System.out.println(uname+" "+password);

//            loginButton = (Button) findViewById(R.id.loginButton);
//          loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//          public void onClick(View view) {
//            Intent i = new Intent(getApplicationContext(), Login.class);
//        startActivity(i);
//      }
// });

//        currentButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(), read_data.class);
//                startActivity(i);
//            }
//        });
    }
}