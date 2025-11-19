import static android.content.Intent.getIntent;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tvScore = findViewById(R.id.finalScore);
        Button btnEmail = findViewById(R.id.emailButton);

        int score = getIntent().getIntExtra("score", 0);
        tvScore.setText("Final Score: " + score);

        btnEmail.setOnClickListener(v -> {
            Intent email = new Intent(Intent.ACTION_SEND);
            email.setType("message/rfc822");
            email.putExtra(Intent.EXTRA_SUBJECT, "My Quiz Score");
            email.putExtra(Intent.EXTRA_TEXT, "My final quiz score is: " + score);
            startActivity(Intent.createChooser(email, "Send Email"));
        });
    }
}
