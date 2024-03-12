package com.example.currencyconverter;

import java.util.ArrayList;
import java.util.Collections;

public class CurrencyType {
    private final String name;
    private final int points;
    private final ArrayList<String> codes;

    public CurrencyType(String name, int points, String... codes) {
        this.name = name;
        this.points = points;
        this.codes = new ArrayList<>();
        Collections.addAll(this.codes, codes);
    }

    public String getName() { return name; }
    public int getPoints() { return points; }
    public ArrayList<String> getCodes() { return codes; }
}
