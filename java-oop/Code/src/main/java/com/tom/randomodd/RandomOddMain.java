package com.tom.randomodd;

import java.util.ArrayList;
import java.util.Arrays;

public class RandomOddMain {

    public static void main(String[] args) {
        ArrayList<Integer> oddEvenNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4,5));
        RandomOddArray oddNumbers = new RandomOddArray(oddEvenNumbers);
        System.out.println(oddEvenNumbers);
        System.out.println(oddNumbers);

        ArrayList<Integer> randomIntegerList = RandomOddArray.createRandomIntegerList(5);
        RandomOddArray oddNumbersFromRandomIntList = new RandomOddArray(randomIntegerList);
        System.out.println(randomIntegerList);
        System.out.println(oddNumbersFromRandomIntList);
    }
}
