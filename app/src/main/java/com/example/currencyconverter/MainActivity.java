package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText amountTextInput;
    private TextInputEditText currencyTypeTextInput;
    private TextView moneyText;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountTextInput = findViewById(R.id.amountTextInput);
        currencyTypeTextInput = findViewById(R.id.currencyTypeTextInput);
        moneyText = findViewById(R.id.moneyText);
        convertButton = findViewById(R.id.convertButton);

        setButtons();
    }

    @SuppressLint("SetTextI18n")
    private void setButtons() {
        convertButton.setOnClickListener(v -> {
            if (!isValidAmountInput()) {
                moneyText.setText("Invalid Input!");
                return;
            }
            moneyText.setText("Input is valid!");
        });
    }

    private boolean isValidAmountInput() {
        String text = String.valueOf(amountTextInput.getText());
        for (int i = 0, n = text.length(); i < n; i++) {
            char character = text.charAt(i);
            if (!(character >= 48 && character <= 57)) { // ascii chart ord
                return false;
            }
        }
        return true;
    }
}