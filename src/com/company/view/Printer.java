package com.company.view;

import com.company.model.Product;

import java.util.List;

public class Printer {
    public void printShoppingList(List<Product> scannedProducts, double totalSum) {
        System.out.println("PRODUCTS LIST\n");
        for(Product product: scannedProducts) {
            System.out.format("%16s%10s\n", product.getName(), String.format("%.2f", product.getPrice()));
        }
        System.out.println("\nTotal sum: " + totalSum);
    }
}
