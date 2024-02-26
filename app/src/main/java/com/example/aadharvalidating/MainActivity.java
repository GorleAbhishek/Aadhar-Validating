package com.example.aadharvalidating;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAadhar;
    private Button buttonValidate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAadhar = findViewById(R.id.editTextAadhar);
        buttonValidate = findViewById(R.id.buttonValidate);
        textViewResult = findViewById(R.id.textViewResult);

        buttonValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aadharNumber = editTextAadhar.getText().toString();
                boolean isValid = VerhoeffAlgorithm.validateVerhoeff(aadharNumber);

                if (isValid) {
                    textViewResult.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                    textViewResult.setText("Valid Aadhar Number");
                } else {
                    textViewResult.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                    textViewResult.setText("Invalid Aadhar Number");
                }
            }
        });
    }
}