package com.company;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        var monthNumber = LocalDate.now().getMonthValue();

        switch (monthNumber) {
            case 1 -> System.out.println("Month is January");
            case 2 -> System.out.println("Month is February");
            default -> System.out.println("Es otro mes guey");
        }
    }
}
