package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvQuestion;
    private ImageView ivImage;
    private Button btnTrue, btnFalse, btnHint;

    private int index = 0;
    private int score = 0;
    private final int QUESTION_POINTS = 20;
    private final int HINT_PENALTY = 5;

    private List<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvQuestion = findViewById(R.id.QuestionText);
        ivImage = findViewById(R.id.QuestionImage);
        btnTrue = findViewById(R.id.trueQ1);
        btnFalse = findViewById(R.id.falseQ1);
        btnHint = findViewById(R.id.hintButton);

        loadQuestions();
        displayQuestion();

        btnTrue.setOnClickListener(v -> checkAnswer(true));
        btnFalse.setOnClickListener(v -> checkAnswer(false));
        btnHint.setOnClickListener(v -> openHint());
    }

    private void loadQuestions() {
        questions = new ArrayList<>();

        questions.add(new Question(getString(R.string.q1), true, getString(R.string.h1), R.drawable.q1));
        questions.add(new Question(getString(R.string.q2), false, getString(R.string.h2), R.drawable.q2));
        questions.add(new Question(getString(R.string.q3), true, getString(R.string.h3), R.drawable.q3));
        questions.add(new Question(getString(R.string.q4), false, getString(R.string.h4), R.drawable.q4));
        questions.add(new Question(getString(R.string.q5), true, getString(R.string.h5), R.drawable.q5));
    }

    private void displayQuestion() {
        Question q = questions.get(index);
        tvQuestion.setText(q.getText());
        ivImage.setImageResource(q.getImageRes());
    }

    private void checkAnswer(boolean userAnswer) {
        if (userAnswer == questions.get(index).isAnswerTrue()) {
            score += QUESTION_POINTS;
            Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT).show();
        }

        index++;
        if (index < questions.size()) {
            displayQuestion();
        } else {
            finishQuiz();
        }
    }

    private void openHint() {
        score -= HINT_PENALTY;
        if (score < 0) score = 0;

        Intent i = new Intent(this, Hint.class);
        i.putExtra("hint", questions.get(index).getHint());
        startActivity(i);
    }

    private void finishQuiz() {
        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra("score", score);
        startActivity(i);
        finish();
    }
}
