package com.example.dummyquizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;
    TextView questionTextView;
    RadioButton ansA, ansB, ansC, ansD;
    Button submitBtn;

    int score = 0;
    int amountOfQuestions = QuestionAndAnswer.questions.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalQuestionsTextView = findViewById(R.id.total_questions);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.choice_a);
        ansB = findViewById(R.id.choice_b);
        ansC = findViewById(R.id.choice_c);
        ansD = findViewById(R.id.choice_d);



        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);


        totalQuestionsTextView.setText("Кількість питань: " + amountOfQuestions);

        loadNextQuestion();
    }

    void loadNextQuestion() {
        if (currentQuestionIndex == amountOfQuestions) {
            finishQuiz();
            return;
        }
        questionTextView.setText(QuestionAndAnswer.questions[currentQuestionIndex]);
        ansA.setText(QuestionAndAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAndAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAndAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAndAnswer.choices[currentQuestionIndex][3]);
    }

    void finishQuiz() {
        String passStatus = "";
        if (score > amountOfQuestions * 0.60) {
            passStatus = "Молодець";
        } else {
            passStatus = "Не поталанило";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Результат " + score + " з " + amountOfQuestions)
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();


    }

    void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        loadNextQuestion();
    }

    @Override
    public void onClick(View view) {
//

        if (view.getId() == R.id.choice_a) {
            selectedAnswer = ansA.getText().toString();
            if (ansA.isChecked()) {
                if (selectedAnswer.equals(QuestionAndAnswer.correctAnswers[currentQuestionIndex])) {
                    score++;
                }
                currentQuestionIndex++;
                loadNextQuestion();
                ansA.setChecked(false);

            }
        }
        if (view.getId() == R.id.choice_b) {
            selectedAnswer = ansB.getText().toString();
            if (ansB.isChecked()) {
                if (selectedAnswer.equals(QuestionAndAnswer.correctAnswers[currentQuestionIndex])) {
                    score++;
                }
                currentQuestionIndex++;
                loadNextQuestion();
                ansB.setChecked(false);

            }
        }
        if (view.getId() == R.id.choice_c) {
            selectedAnswer = ansC.getText().toString();
            if (ansC.isChecked()) {
                if (selectedAnswer.equals(QuestionAndAnswer.correctAnswers[currentQuestionIndex])) {
                    score++;
                }
                currentQuestionIndex++;
                loadNextQuestion();
                ansC.setChecked(false);

            }
        }
        if (view.getId() == R.id.choice_d) {
            selectedAnswer = ansD.getText().toString();
            if (ansD.isChecked()) {
                if (selectedAnswer.equals(QuestionAndAnswer.correctAnswers[currentQuestionIndex])) {
                    score++;
                }
                currentQuestionIndex++;
                loadNextQuestion();
                ansD.setChecked(false);

            }
        }
    }
}