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
    private TextView pointsText;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CurrencyConverter.initialize();

        amountTextInput = findViewById(R.id.amountTextInput);
        currencyTypeTextInput = findViewById(R.id.currencyTypeTextInput);
        pointsText = findViewById(R.id.pointsText);
        convertButton = findViewById(R.id.convertButton);

        setButtons();
    }

    @SuppressLint("SetTextI18n")
    private void setButtons() {
        convertButton.setOnClickListener(v -> {
            if (!isValidAmountInput()) {
                pointsText.setText("Amount Input must be a number!");
                return;
            }
            try {
                String userInput = String.valueOf(currencyTypeTextInput.getText());
                String userCurrency = userInput.split(" ")[0];
                int userAmount = (int)Double.parseDouble(String.valueOf(amountTextInput.getText()));
                amountTextInput.setText(String.valueOf(userAmount));
                if (!CurrencyConverter.isValidCurrency(userCurrency)) {
                    pointsText.setText("Currency type does not exist!");
                    return;
                }
                pointsText.setText(String.format("%s points", CurrencyConverter.convertCurrency(userCurrency, userAmount)));
            } catch (ArrayIndexOutOfBoundsException err) {
                pointsText.setText("Invalid Currency Type!");
            } catch (NumberFormatException err) {
                pointsText.setText("Invalid Amount Input!");
            }
        });
    }

    private boolean isValidAmountInput() {
        String text = String.valueOf(amountTextInput.getText());
        for (int i = 0, n = text.length(); i < n; i++) {
            char character = text.charAt(i);
            if (!(character >= 48 && character <= 57) && character != '.') { // ascii chart ord
                return false;
            }
        }
        return true;
    }
}