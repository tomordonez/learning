package com.tom.oddarray;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> oddEvenNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        OddArrayList oddNumbers = new OddArrayList();

        oddNumbers.addAll(oddEvenNumbers);

        System.out.println(oddEvenNumbers);
        System.out.println(oddNumbers);
    }
}
