package com.tom.S4_Polymorphism.randomodd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomOddArray extends ArrayList<Integer> {
    public RandomOddArray(List<Integer> oddEvenNumbers) {
        super(oddEvenNumbers.stream().filter(RandomOddArray::addOddNumber).toList());
    }

    public static boolean addOddNumber(Integer number) {
        return number % 2 == 1;
    }

    public static ArrayList<Integer> createRandomIntegerList(Integer seedNumber) {
        Random randomNumber = new Random(seedNumber);
        ArrayList<Integer> randomIntegerList = new ArrayList<>();
        int counter = 0;
        while (counter < 10) {
            randomIntegerList.add(randomNumber.nextInt(10));
            counter++;
        }
        return randomIntegerList;
    }
}
