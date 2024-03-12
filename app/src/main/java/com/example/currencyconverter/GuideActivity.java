package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GuideActivity extends AppCompatActivity {
    private TextView currenciesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        currenciesText = findViewById(R.id.currenciesText);
        currenciesText.setText(CurrencyConverter.getCurrenciesText());
    }
}