package com.example.hydroponics_major_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.CollectionReference;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    private FirebaseFirestore firestore;
    private CollectionReference usersCollection;
  //  private DatabaseReference fullName;
  //  private DatabaseReference userName;
  //  private DatabaseReference email;
  //  private DatabaseReference passwd;
    EditText registration_fullname;
    EditText registration_username;

    EditText registration_email;
    EditText registration_password;
    Button registerButton;

    TextView loginRedirectText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        firestore = FirebaseFirestore.getInstance();
        registration_fullname = findViewById(R.id.registration_fullname);
        registration_username = findViewById(R.id.registration_username);
        registration_email = findViewById(R.id.registration_email);
        registration_password = findViewById(R.id.registration_password);
        registerButton= findViewById(R.id.registerButton);
        loginRedirectText = findViewById(R.id.loginRedirectText);



        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName1 = registration_fullname.getText().toString();
                String username1 = registration_username.getText().toString();
                String email1 = registration_email.getText().toString();
                String password1 = registration_password.getText().toString();

                usersCollection = firestore.collection("users")
                        .document("uc3tKaMtqMqZOv5EQMe4").collection(username1);
                if (isValidRegistration(fullName1, username1, email1, password1)) {

                    Map<String, Object> user = new HashMap<>();
                    user.put("name", fullName1);
                    user.put("userName", username1);
                    user.put("email", email1);
                    user.put("password", password1);

                    usersCollection.add(user)
                            .addOnSuccessListener(documentReference -> {
                                Toast.makeText(Register.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(), Login.class);
                                startActivity(i);
                            })
                            .addOnFailureListener(e -> {
                                Toast.makeText(Register.this, "Registration Failed! Please check your input.", Toast.LENGTH_SHORT).show();
                            });
                } else {
                    Toast.makeText(Register.this, "Registration Failed! Please check your input.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }

    private boolean isValidRegistration(String fullName, String username, String email, String password) {
        boolean isFullNameValid = !fullName.isEmpty();
        boolean isUsernameValid = !username.isEmpty();
        boolean isEmailValid = isValidEmail(email);
        boolean isPasswordValid = password.length() >= 6;
        return isFullNameValid && isUsernameValid && isEmailValid && isPasswordValid;
    }

    private boolean isValidEmail(String email) {
        return email.contains("@");
    }
}