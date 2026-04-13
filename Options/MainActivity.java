package com.example.assignment_3;

import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox cbPizza, cbBurger, cbPasta, cbSandwich;
    RadioGroup radioGroup;
    Button btnSubmit;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbPizza = findViewById(R.id.cbPizza);
        cbBurger = findViewById(R.id.cbBurger);
        cbPasta = findViewById(R.id.cbPasta);
        cbSandwich = findViewById(R.id.cbSandwich);

        radioGroup = findViewById(R.id.radioGroup);
        btnSubmit = findViewById(R.id.btnSubmit);
        resultText = findViewById(R.id.resultText);

        btnSubmit.setOnClickListener(v -> {

            StringBuilder order = new StringBuilder("Selected Items:\n");

            if (cbPizza.isChecked()) order.append("• Pizza\n");
            if (cbBurger.isChecked()) order.append("• Burger\n");
            if (cbPasta.isChecked()) order.append("• Pasta\n");
            if (cbSandwich.isChecked()) order.append("• Sandwich\n");

            if (order.toString().equals("Selected Items:\n")) {
                order.append("No items selected\n");
            }

            int selectedId = radioGroup.getCheckedRadioButtonId();

            String payment = "No payment selected";

            if (selectedId != -1) {
                RadioButton rb = findViewById(selectedId);
                payment = rb.getText().toString();
            }

            order.append("\nPayment Method: ").append(payment);

            resultText.setText(order.toString());

            Toast.makeText(this, "Order Submitted!", Toast.LENGTH_SHORT).show();
        });
    }
}
