package com.example.currencyconverter;

import java.util.HashMap;
import java.util.ArrayList;

public class CurrencyConverter {
    private static final HashMap<String, Integer> currencies = new HashMap<>();
    private static final ArrayList<CurrencyType> currencyTypes = new ArrayList<>();
    private static boolean initialized = false;

    public static void initialize() {
        if (!initialized) {
            initialized = true;

            currencyTypes.add(new CurrencyType("Base Point", 1, "BASE", "POINT", "POINTS"));
            currencyTypes.add(new CurrencyType("Gold Septim", 100, "GOLD"));
            currencyTypes.add(new CurrencyType("Silver Septim", 50, "SILVER"));
            currencyTypes.add(new CurrencyType("Copper Septim", 10, "COPPER"));
            currencyTypes.add(new CurrencyType("Dwemer Coin", 75, "DWEMER", "COIN"));
            currencyTypes.add(new CurrencyType("Imperial Drake", 90, "IMPERIAL", "DRAKE"));
            currencyTypes.add(new CurrencyType("Akaviri Dragongold", 150, "AKAVIRI", "DRAGONGOLD"));

            for (CurrencyType type : currencyTypes) {
                ArrayList<String> codes = type.getCodes();
                for (int i = 0, n = codes.size(); i < n; i++) {
                    currencies.put(codes.get(i), type.getPoints());
                }
            }
        }
    }

    public static String getCurrenciesText() {
        StringBuilder output = new StringBuilder();
        for (int i = 0, n = currencyTypes.size(); i < n; i++) {
            CurrencyType type = currencyTypes.get(i);
            String pointStr = type.getPoints() > 1 ? "points" : "point";
            output.append(String.format("%s: %s %s\n",
                    type.getName(), type.getPoints(), pointStr));
        }
        return output.toString();
    }

    public static String getValidCurrency(String input) {
        String[] words = input.split(" ");
        for (String word : words) {
            if (isValidCurrency(word)) {
                return word;
            }
        }
        return null;
    }

    public static boolean isValidCurrency(String currency) {
        for (String key : currencies.keySet()) {
            if (currency.equalsIgnoreCase(key)) {
                return true;
            }
        }
        return false;
    }

    public static String convertCurrency(String type, int amount) {
        int result = currencies.get(type.toUpperCase()) * amount;
        String strResult = String.valueOf(result);
        if (result < 1000) {
            return strResult;
        }
        StringBuilder formattedResult = new StringBuilder();
        for (int i = strResult.length() - 1, n = 1; i >= 0; i--, n++) {
            formattedResult.insert(0, strResult.charAt(i));
            if (n % 3 == 0 && n != strResult.length()) {
                formattedResult.insert(0, ",");
            }
        }
        return formattedResult.toString();
    }
}
