package com.tom.oddarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class OddArrayList extends ArrayList<Integer> {

    public OddArrayList() {

    }
    public OddArrayList(Integer... numbers) {
        super(Arrays.stream(numbers).filter(OddArrayList::isOdd).toList());
    }
    @Override
    public boolean add(Integer number) {
        if (isOdd(number)) {
            return super.add(number);
        } else {
            return false;
        }
    }

    @Override
    public void add(int index, Integer number) {
        if (isOdd(number)) {
            super.add(index, number);
        }
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return super.addAll(c.stream().filter(OddArrayList::isOdd).toList());
    }

    public static boolean isOdd(Integer number) {
        return Math.abs(number) % 2 == 1;
    }
}
