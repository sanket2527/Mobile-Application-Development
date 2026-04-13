package com.example.contact;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ActionActivity extends AppCompatActivity {

    ImageButton callBtn, smsBtn, whatsappBtn;
    TextView nameTv;
    String number, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        callBtn = findViewById(R.id.callBtn);
        smsBtn = findViewById(R.id.smsBtn);
        whatsappBtn = findViewById(R.id.whatsappBtn);
        nameTv = findViewById(R.id.nameTv);

        name = getIntent().getStringExtra("name");
        number = getIntent().getStringExtra("number");

        nameTv.setText(name);

        callBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
            startActivity(intent);
        });

        smsBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + number));
            startActivity(intent);
        });

        whatsappBtn.setOnClickListener(v -> {
            String url = "https://api.whatsapp.com/send?phone=" + number;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
    }
}
