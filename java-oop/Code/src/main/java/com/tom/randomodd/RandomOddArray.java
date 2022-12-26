package com.tom.randomodd;

import java.util.ArrayList;
import java.util.List;

public class RandomOddArray extends ArrayList<Integer> {
    public RandomOddArray(List<Integer> oddEvenNumbers) {
        super(oddEvenNumbers.stream().filter(RandomOddArray::addOddNumber).toList());
    }

    public static boolean addOddNumber(Integer number) {
        return number % 2 == 1;
    }
}
