package com.tom.oddarrayagain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OddArrayAgainMain {
    public static void main(String[] args) {
        List<Integer> oddAndEvenNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(oddAndEvenNumbers);

        OddArrayAgainList onlyOddNumbers = new OddArrayAgainList(oddAndEvenNumbers);
        System.out.println(onlyOddNumbers);

        OddArrayAgainList onlyOddNumbersWithAddMethod = new OddArrayAgainList();
        onlyOddNumbersWithAddMethod.add(0);
        onlyOddNumbersWithAddMethod.add(1);
        onlyOddNumbersWithAddMethod.add(2);
        onlyOddNumbersWithAddMethod.add(3);
        System.out.println(onlyOddNumbersWithAddMethod);

        OddArrayAgainList onlyOddNumbersWithAddAll = new OddArrayAgainList();
        onlyOddNumbersWithAddAll.addAll(oddAndEvenNumbers);
        System.out.println(onlyOddNumbersWithAddAll);

        onlyOddNumbersWithAddAll.addAll(5, oddAndEvenNumbers);
        System.out.println(onlyOddNumbersWithAddAll);

    }
}
