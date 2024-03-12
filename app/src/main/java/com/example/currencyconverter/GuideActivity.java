package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.util.Log;

public class GuideActivity extends AppCompatActivity {
    private TextView currenciesText;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        currenciesText = findViewById(R.id.currenciesText);
        backButton = findViewById(R.id.backButton);
        Log.d("DEBUG:", CurrencyConverter.getCurrenciesText());

        currenciesText.setText(CurrencyConverter.getCurrenciesText());
        setButtons();
    }

    private void setButtons() {
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}