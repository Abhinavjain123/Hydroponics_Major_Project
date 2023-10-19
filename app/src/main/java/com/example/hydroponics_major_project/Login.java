package com.example.hydroponics_major_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;
    TextView signupText;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Username = "username";
    public static final String Password = "password";
    SharedPreferences sharedpreferences;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        signupText = findViewById(R.id.signupText);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        db = FirebaseFirestore.getInstance();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String enteredUsername = username.getText().toString();
                final String enteredPassword = password.getText().toString();

               CollectionReference usersCollection = db.collection("users");
//                Query query = usersCollection.whereEqualTo("userName", enteredUsername);
//                DocumentReference userDocument = usersCollection.document(enteredUsername);
                CollectionReference userNameCollection = usersCollection.document("uc3tKaMtqMqZOv5EQMe4").collection(enteredUsername);
//                Query query = userNameCollection.whereEqualTo("username", enteredUsername);

                    userNameCollection.get().addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            QuerySnapshot querySnapshot = task.getResult();
                            if (querySnapshot != null && !querySnapshot.isEmpty()) {
                                DocumentSnapshot document = querySnapshot.getDocuments().get(0);
                                String storedPassword = document.getString("password");

                            if (enteredPassword.equals(storedPassword)) {
                                Toast.makeText(Login.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                                SharedPreferences.Editor editor = sharedpreferences.edit();
                                editor.putString(Username, enteredUsername);
                                editor.putString(Password, enteredPassword);
                                editor.commit();

                                Intent i = new Intent(Login.this, MainActivity.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(Login.this, "Login Failed! Incorrect password.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Login.this, "Login Failed! User not found.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Login.this, "Login Failed! Please try again.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Register.class);
                startActivity(i);
            }
        });
    }
}
