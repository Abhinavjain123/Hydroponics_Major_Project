package com.example.hydroponics_major_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ScrollActivity extends AppCompatActivity {

    Button add;
    AlertDialog dialog;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        add=findViewById(R.id.add_button);
        layout = findViewById(R.id.container);

        buildDialog();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
    }

    private void buildDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View view = getLayoutInflater().inflate(R.layout.dialog, null);
        EditText editName=view.findViewById(R.id.nameEdit);
        builder.setView(view);
        builder.setTitle("Enter name").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                addCard(editName.getText().toString());

            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog = builder.create();
    }

    private void addCard(String name) {
        View view = getLayoutInflater().inflate(R.layout.plant,null);
        TextView nameView=view.findViewById(R.id.name);
        Button delete=view.findViewById(R.id.delete);
        CardView card = view.findViewById(R.id.card);

        nameView.setText(name);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.removeView(view);
            }
        });
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LiveStatus.class);
                i.putExtra("cropName", name);
                startActivity(i);
            }
        });
        layout.addView(view);
    }
}