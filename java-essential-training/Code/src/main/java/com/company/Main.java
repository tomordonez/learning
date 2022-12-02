package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter score for USA: ");
        var usaScore = scanner.nextInt();

        System.out.print("Enter score for England: ");
        var englandScore = scanner.nextInt();

        var winner = (usaScore > englandScore) ? "USA won" : "England won";
        System.out.println(winner);
    }
}
