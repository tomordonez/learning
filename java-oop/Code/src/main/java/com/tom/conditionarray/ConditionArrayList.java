package com.tom.conditionarray;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ConditionArrayList extends ArrayList<Integer> {
    public ConditionArrayList() {
    }

    public ConditionArrayList(ArrayList<Integer> randomNumberList) {
        super.addAll(randomNumberList);
    }

    public ArrayList<Integer> filterByPredicate(Predicate<Integer> predicate) {
        List<Integer> filteredList = this.stream().filter(predicate).toList();
        return new ArrayList<>(filteredList);
    }
}
