package com.company;

import com.company.model.ClothingItem;

import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        ClothingItem newItem = new ClothingItem(ClothingItem.SHIRT, 2, 55.56);

        var itemType = newItem.getItemType();
        var quantity = newItem.getQuantity();
        var price = newItem.getPrice();

        var totalPrice = quantity * price;

        var priceCurrencyFormat = NumberFormat.getCurrencyInstance();
        var output = String.format("Item: %s. Total price: %s",
                itemType,
                priceCurrencyFormat.format(totalPrice));

        System.out.println(output);

    }

}
