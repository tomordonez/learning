package com.tom.modarray;

import java.util.Arrays;

public class ModArrayListMain {
    public static void main(String[] args) {
        ModArrayList marvel = new ModArrayList();
        marvel.addAll(Arrays.asList("Namor", "Thor", "Hope", "Groot"));

        System.out.println(marvel.getUsingMod(0));
        System.out.println(marvel.getUsingMod(5));
        System.out.println(marvel.getUsingMod(6));
        System.out.println(marvel.getUsingMod(-6));
    }
}