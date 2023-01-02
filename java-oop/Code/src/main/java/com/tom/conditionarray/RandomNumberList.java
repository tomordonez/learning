package com.tom.conditionarray;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumberList {

    public RandomNumberList() {
    }

    public static ArrayList<Integer> createList(int seed, int bound, int listSize) {
        Random randomStream = new Random(seed);
        ArrayList<Integer> randomNumberList = new ArrayList<>();
        int counter = 0;
        while (counter < listSize) {
            randomNumberList.add(randomStream.nextInt(bound));
            counter++;
        }
        return randomNumberList;
    }
}
