package com.example.dummyquizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
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
        ansA = findViewById(R.id.ans_a_btn);
        ansB = findViewById(R.id.ans_b_btn);
        ansC = findViewById(R.id.ans_c_btn);
        ansD = findViewById(R.id.ans_d_btn);

        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Кількість питань: " + amountOfQuestions);
        
        loadNextQuestion();
    }

     void loadNextQuestion() {
         if(currentQuestionIndex == amountOfQuestions ){
             finishQuiz();
             return;
         }
        questionTextView.setText(QuestionAndAnswer.questions[currentQuestionIndex]);
        ansA.setText(QuestionAndAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAndAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAndAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAndAnswer.choices[currentQuestionIndex][3]);
    }
    void finishQuiz(){
        String passStatus = "";
        if(score > amountOfQuestions*0.60){
            passStatus = "Молодець";
        }else{
            passStatus = "Не поталанило";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Результат "+ score+" з "+ amountOfQuestions)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();


    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNextQuestion();
    }
    @Override
    public void onClick(View view) {
        ansA.setBackgroundColor(Color.parseColor("#FF6200EE"));
        ansB.setBackgroundColor(Color.parseColor("#FF6200EE"));
        ansC.setBackgroundColor(Color.parseColor("#FF6200EE"));
        ansD.setBackgroundColor(Color.parseColor("#FF6200EE"));

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(QuestionAndAnswer.correctAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNextQuestion();


       }
        else{
            //choices button clicked
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);

        }


    }
}