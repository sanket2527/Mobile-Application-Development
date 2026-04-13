package com.example.profile86;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView nameText, emailText, phoneText, locationText, dobText;
    Button editProfileBtn;
    boolean isEditing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.nameText);
        emailText = findViewById(R.id.emailText);
        phoneText = findViewById(R.id.phoneText);
        locationText = findViewById(R.id.locationText);
        dobText = findViewById(R.id.dobText);

        editProfileBtn = findViewById(R.id.editProfileBtn);

        editProfileBtn.setOnClickListener(v -> {

            if (!isEditing) {

                nameText = convertToEditText(nameText);
                emailText = convertToEditText(emailText);
                phoneText = convertToEditText(phoneText);
                locationText = convertToEditText(locationText);
                dobText = convertToEditText(dobText);

                editProfileBtn.setText("Save");
                isEditing = true;

            } else {

                nameText = convertToTextView((EditText) nameText);
                emailText = convertToTextView((EditText) emailText);
                phoneText = convertToTextView((EditText) phoneText);
                locationText = convertToTextView((EditText) locationText);
                dobText = convertToTextView((EditText) dobText);

                editProfileBtn.setText("Edit Profile");
                isEditing = false;

                Toast.makeText(this, "Profile Saved", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private EditText convertToEditText(TextView tv) {
        ViewGroup parent = (ViewGroup) tv.getParent();
        int index = parent.indexOfChild(tv);

        EditText et = new EditText(this);
        et.setText(tv.getText());
        et.setLayoutParams(tv.getLayoutParams());

        parent.removeView(tv);
        parent.addView(et, index);

        return et;
    }

    private TextView convertToTextView(EditText et) {
        ViewGroup parent = (ViewGroup) et.getParent();
        int index = parent.indexOfChild(et);

        TextView tv = new TextView(this);
        tv.setText(et.getText());
        tv.setLayoutParams(et.getLayoutParams());

        parent.removeView(et);
        parent.addView(tv, index);

        return tv;
    }
}
