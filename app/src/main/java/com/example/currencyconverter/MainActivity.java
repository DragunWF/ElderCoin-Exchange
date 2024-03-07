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
        CurrencyConverter.initialize();

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
                moneyText.setText("Invalid Amount Input!");
                return;
            }
            try {
                String userInput = String.valueOf(currencyTypeTextInput.getText());
                String userCurrency = userInput.split(" ")[0];
                if (!CurrencyConverter.isValidCurrency(userCurrency)) {
                    moneyText.setText("Currency type does not exist!");
                    return;
                }
                moneyText.setText(String.format("%s %s", CurrencyConverter.convertCurrency(userCurrency, 1)));
            } catch (ArrayIndexOutOfBoundsException err) {
                moneyText.setText("Invalid Currency Type!");
            } catch (NumberFormatException err) {
                moneyText.setText("");
            }
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