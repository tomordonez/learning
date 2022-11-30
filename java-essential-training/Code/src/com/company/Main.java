package com.company;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        var doubleValue = 10_000_000.53;

        var numF = NumberFormat.getInstance();
        System.out.println("Number: " + numF.format(doubleValue));

        var intF = NumberFormat.getIntegerInstance();
        System.out.println("Number: " + intF.format(doubleValue));

        var locale = new Locale("es", "CO");
        var numES = NumberFormat.getNumberInstance(locale);
        System.out.println("Number: " + numES.format(doubleValue));

        var currencyFormat = NumberFormat.getCurrencyInstance(locale);
        System.out.println("Number: " + currencyFormat.format(doubleValue));

        var decimal = new DecimalFormat("$0.00");
        System.out.println("Number: " + decimal.format(3.1415));
        // Output: $3.14
    }
}
