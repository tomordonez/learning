package com.tom.S5_Abstraction.abstractfilereader;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DigitFileReader digitFileReader = new DigitFileReader();
        String filename = "s5_message.txt";
        ArrayList<Integer> digitsFromTextFile = digitFileReader.parseDigits(filename);

        System.out.println(digitsFromTextFile);
    }
}
