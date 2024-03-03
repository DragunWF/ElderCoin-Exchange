package com.example.currencyconverter;

import java.util.HashMap;
public class CurrencyConverter {
    private static HashMap<String, Integer> currencies = new HashMap<>();

    public static boolean isValidCurrency(String currency) {
        for (String key : currencies.keySet()) {
            if (currency.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public static double convertCurrency(double amount) {
        return 1.0;
    }
}
