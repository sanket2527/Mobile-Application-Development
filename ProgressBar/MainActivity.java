package com.example.yourapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ProgressBar horizontalBar;
    TextView txtProgress;
    Button btnNext;

    int progress = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        horizontalBar = findViewById(R.id.horizontalBar);
        txtProgress = findViewById(R.id.txtProgress);
        btnNext = findViewById(R.id.btnNext);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progress < 100) {
                    progress += 2;

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            horizontalBar.setProgress(progress);
                            txtProgress.setText(progress + "%");
                        }
                    });

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CircularActivity.class);
            startActivity(intent);
        });
    }
}
