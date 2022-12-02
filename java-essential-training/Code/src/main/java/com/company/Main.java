package com.company;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Build an array of months from January to December
        var monthCounter = 0;
        String[] monthStrings = new String[12];
        while (monthCounter < 12) {
            monthStrings[monthCounter] = String.valueOf(LocalDate.now().plusMonths(monthCounter + 1).getMonth());
            monthCounter += 1;
        }
        System.out.println(Arrays.toString(monthStrings));

        // Print four quarters like:
        // Q1: January - March
        // Q2: April - June
        // Q3: July - September
        // Q4: October - December
        String[] quarterMonths = new String[3];
        var quarterCounter = 0;
        var quarterNumber = 0;
        for (int i = 0; i < monthStrings.length; i++) {
            quarterMonths[quarterCounter] = monthStrings[i];
            quarterCounter++;
            if ((i+1) % 3 == 0) {
                System.out.println("Q" + (quarterNumber+1) + ": " + quarterMonths[0] + " - " + quarterMonths[quarterMonths.length - 1]);
                quarterMonths = new String[3];
                quarterCounter = 0;
                quarterNumber++;
            }
        }
    }
}
