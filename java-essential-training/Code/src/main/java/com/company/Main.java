package com.company;

import com.company.model.ClothingItem;
import com.company.model.ClothingSize;
import com.company.model.Shirt;

import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        ClothingItem newItem = new Shirt(
                ClothingSize.L,
                2,
                55.56);

        var itemType = newItem.getItemType();
        var size = newItem.getSize();
        var quantity = newItem.getQuantity();
        var price = newItem.getPrice();

        var totalPrice = quantity * price;

        var priceCurrencyFormat = NumberFormat.getCurrencyInstance();
        var output = String.format("Item: %s. Size: %s. Total price: %s",
                itemType,
                size,
                priceCurrencyFormat.format(totalPrice));

        System.out.println(output);

    }

}
