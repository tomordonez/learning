package com.company;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var filename = "marvel-characters.csv";
        LoadFile.checkFileExists(filename);
        var csvData = LoadFile.readCsv(filename);
        for (String[] line : csvData) {
            System.out.println(Arrays.toString(line));
        }
    }

}
