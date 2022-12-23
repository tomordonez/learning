package com.tom.oddarrayagain;

import com.tom.oddarray.OddArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OddArrayAgainList extends ArrayList<Integer>{
    public OddArrayAgainList(List<Integer> integerList){
        super(filterNumberListToOddOnly(integerList));
    }

    private static List<Integer> filterNumberListToOddOnly(List<Integer> integerList) {
        return integerList.stream().filter(OddArrayList::isOdd).toList();
    }

    public OddArrayAgainList() {
    }

    @Override
    public boolean add(Integer number) {
        if (OddArrayAgainList.isOdd(number)) {
            return super.add(number);
        } else {
            return false;
        }
    }

    @Override
    public void add(int index, Integer number) {
        if (OddArrayAgainList.isOdd(number)) {
            super.add(index, number);
        } else {
            System.out.println("Can't add an even number");
        }
    }

    @Override
    public boolean addAll(Collection<? extends Integer> numberList) {
        return super.addAll(numberList.stream().filter(OddArrayList::isOdd).toList());
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> numberList) {
        return super.addAll(index, numberList.stream().filter(OddArrayList::isOdd).toList());
    }
    public static boolean isOdd(int number) {
        return Math.abs(number) % 2 == 1;
    }
}
