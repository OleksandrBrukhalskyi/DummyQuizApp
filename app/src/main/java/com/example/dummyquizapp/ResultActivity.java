package com.example.dummyquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultView = findViewById(R.id.textView);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("name");
            int score = bundle.getInt("score");
            int amountOfQuestions = bundle.getInt("amountOfQuestions");
            System.out.println("NAME: " + name);
            System.out.println("SCORE: " + score);
            System.out.println("QUESTS: " + amountOfQuestions);
            resultView.setText( name + "!" + " Ваш результат: " + score + " з " + amountOfQuestions);
        }


    }
}