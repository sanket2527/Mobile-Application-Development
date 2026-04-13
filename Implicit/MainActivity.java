package com.example.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnBrowser, btnCall, btnCamera, btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBrowser = findViewById(R.id.btnBrowser);
        btnCall = findViewById(R.id.btnCall);
        btnCamera = findViewById(R.id.btnCamera);
        btnEmail = findViewById(R.id.btnEmail);

        btnBrowser.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            startActivity(intent);
        });

        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9876543210"));
            startActivity(intent);
        });

        btnCamera.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "No Camera App Found", Toast.LENGTH_SHORT).show();
            }
        });

        btnEmail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:example@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Test Subject");
            intent.putExtra(Intent.EXTRA_TEXT, "Hello from App");

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "No Email App Found", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
