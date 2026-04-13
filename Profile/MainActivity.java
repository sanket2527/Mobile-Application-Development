package com.example.yourapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView profileImage;
    TextView nameText, emailText, phoneText, locationText, dobText;
    Button editProfileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileImage = findViewById(R.id.profileImage);
        nameText = findViewById(R.id.nameText);
        emailText = findViewById(R.id.emailText);
        phoneText = findViewById(R.id.phoneText);
        locationText = findViewById(R.id.locationText);
        dobText = findViewById(R.id.dobText);
        editProfileBtn = findViewById(R.id.editProfileBtn);

        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,
                        "Edit Profile Clicked",
                        Toast.LENGTH_SHORT).show();

                nameText.setText("Updated Name");
                emailText.setText("updated@email.com");
            }
        });
    }
}
