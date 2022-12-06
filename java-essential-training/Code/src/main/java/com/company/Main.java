package com.company;

import com.company.model.ClothingItem;
import com.company.model.ClothingSize;
import com.company.model.Hat;
import com.company.model.Shirt;

import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {

        String[] colors = new String[3];
        colors[0] = "rojo";
        colors[1] = "azul";
        colors[2] = "verde";

        for (String color : colors) {
            System.out.println(color);
        }

        ClothingItem[] items = {
            new Shirt(
                    ClothingSize.L,
                    2,
                    55.56),
            new Hat(
                    ClothingSize.M,
                    1,
                    25.99)
        };

        for (ClothingItem item : items) {
            displayItemDetails(item);
        }

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
