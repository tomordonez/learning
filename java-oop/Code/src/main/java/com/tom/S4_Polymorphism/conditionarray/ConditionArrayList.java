package com.tom.S4_Polymorphism.conditionarray;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ConditionArrayList extends ArrayList<Integer> {
    public ConditionArrayList(List<Integer> numberList) {
        super.addAll(numberList);
    }

    public ConditionArrayList(ArrayList<Integer> randomNumberList) {
        super.addAll(randomNumberList);
    }

    public ArrayList<Integer> filterByPredicate(Predicate<Integer> predicate) {
        List<Integer> filteredList = this.stream().filter(predicate).toList();
        return new ArrayList<>(filteredList);
    }

    public static boolean isPrime(Integer number) {
        if (number <= 1) {
            return false;
        }
        for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}
