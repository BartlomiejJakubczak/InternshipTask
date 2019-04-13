package com.company.view;

import com.company.model.Product;

import java.util.List;

public class Printer {
    public void printShoppingList(List<Product> scannedProducts, double totalSum) {
        System.out.println("PRODUCTS LIST");
        System.out.println(scannedProducts);
        System.out.println("Total sum: " + totalSum);
    }
}
