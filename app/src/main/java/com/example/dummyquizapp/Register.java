package com.example.dummyquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener {
    EditText name, email;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        btn = findViewById(R.id.btn1);
        btn.setOnClickListener(this);
    }
    public void validation(View v) {
        String fieldName = name.getText().toString();
        String fieldEmail = email.getText().toString();

        if(fieldName.equals("") || fieldEmail.equals("")) {
            Toast.makeText(getBaseContext(), "Введіть Ваше імʼя та електронну адресу", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent in = new Intent(Register.this, MainActivity.class);
            in.putExtra("name", fieldName);
            in.putExtra("email", fieldEmail);
            startActivity(in);
        }
    }
    @Override
    public void onClick(View view) {
        validation(view);
    }
}