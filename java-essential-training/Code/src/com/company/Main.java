package com.company;

public class Main {
    public static void main(String[] args) {

        var item = "Shirt";
        var size = "M";
        var price = 14.99;
        var color = "Red";

        var template = "Clothing item: %s, size %s, price $%.2f, color %s";
        var clothingFormat = String.format(template, item, size, price, color);
        System.out.println(clothingFormat);
    }
}
