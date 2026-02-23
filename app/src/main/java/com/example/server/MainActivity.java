package com.example.server;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private String[] questions = {
            "Java is fully based on OOPs",
            "Java has abstract class",
            "Java uses the concept of pointers",
            "Java is part of C++",
            "Java was made in 1972" , "java before name Oak " , "java is static language"
    };

    private boolean[] answer = {true, true, false, false, false,true,true};

    Button yes, no;
    TextView question , textView2;
    private int index = 0;
    private int score = 0;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question = findViewById(R.id.question);
        textView2=findViewById(R.id.textView2);

        question.setText(questions[index]);

        yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (index <= questions.length - 1) {
                    if (answer[index]) {
                        score++;
                    }
                    index++;
                    if (index <= questions.length - 1) {
                        question.setText(questions[index]);
                    } else {
                        Toast.makeText(MainActivity.this, "YOUR SCORE IS: " + score, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    textView2.setText( " YOUR SCORE IS : " + score);
                    Toast.makeText(MainActivity.this, "RESTART APK TO PLAY AGAIN", Toast.LENGTH_SHORT).show();
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (index <= questions.length - 1) {
                    if (!answer[index]) {
                        score++;
                    }
                    index++;
                    if (index <= questions.length - 1) {
                        question.setText(questions[index]);
                    } else {
                        Toast.makeText(MainActivity.this, "YOUR SCORE IS: " + score, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    textView2.setText( " YOUR SCORE IS : " + score);
                    Toast.makeText(MainActivity.this, "RESTART APK TO PLAY AGAIN", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}