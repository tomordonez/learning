package com.company;

import com.company.model.ClothingItem;
import com.company.model.ClothingSize;
import com.company.model.Hat;
import com.company.model.Shirt;

import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        ClothingItem shirt = new Shirt(
                ClothingSize.L,
                2,
                55.56);

        ClothingItem hat = new Hat(
                ClothingSize.M,
                1,
                25.99);

        displayItemDetails(shirt);
        displayItemDetails(hat);
    }

    private static void displayItemDetails(ClothingItem item) {
        var totalPrice = item.getQuantity() * item.getPrice();

        var priceCurrencyFormat = NumberFormat.getCurrencyInstance();
        var output = String.format("Item: %s. Size: %s. Qty: %s. Total price: %s",
                item.getItemType(),
                item.getSize(),
                item.getQuantity(),
                priceCurrencyFormat.format(totalPrice));

        System.out.println(output);
    }

}
