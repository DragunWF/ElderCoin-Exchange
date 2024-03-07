package com.example.currencyconverter;

import java.util.HashMap;
public class CurrencyConverter {
    private static HashMap<String, Integer> currencies = new HashMap<>();
    private static boolean initialized = false;

    public static void initialize() {
        if (!initialized) {
            initialized = true;

            currencies.put("POINTS", 1);
            currencies.put("POINT", 1);

            currencies.put("GOLD", 100);
            currencies.put("SILVER", 50);
            currencies.put("COPPER", 10);
            currencies.put("DWEMER", 75);
            currencies.put("IMPERIAL", 90);

            currencies.put("AKAVIRI", 150);
            currencies.put("DRAGONGOLD", 150);
        }
    }

    public static boolean isValidCurrency(String currency) {
        for (String key : currencies.keySet()) {
            if (currency.equalsIgnoreCase(key)) {
                return true;
            }
        }
        return false;
    }

    public static int convertCurrency(String type, int amount) {
        return currencies.get(type.toUpperCase()) * amount;
    }
}
