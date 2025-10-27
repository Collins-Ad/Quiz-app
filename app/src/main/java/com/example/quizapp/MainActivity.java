package com.example.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView seeQuestion1;

    Button trueQ1;
    Button falseQ1;
    Button finish;
    Boolean clicked = false;
//vars
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        seeQuestion1 = (TextView) findViewById(R.id.Question1);
        trueQ1 = (Button) findViewById(R.id.trueQ1);
        falseQ1 = (Button) findViewById(R.id.falseQ1);
        finish = (Button) findViewById(R.id.FinishedButton);
        trueQ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer1 = "True, he can";
                seeQuestion1.setText(answer1);
                clicked = true;
            }
        });
        falseQ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fake1 = "False, he can";
                seeQuestion1.setText(fake1);
                clicked = false;
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String points = "";
                if (clicked)
                {
                    points = "Congratulations you have 100 points";
                } else
                {
                    points = "False, you have 0 points, try again";
                }
                seeQuestion1.setText(points);
            }
        });
    }
}