package com.company.view;

import com.company.model.Product;

public class LCDDisplay {

    public void printWaitingLine() {
        System.out.println("Waiting for barcode to scan...");
    }

    public void printErrorEmpty() {
        System.out.println("Invalid bar-code");
    }

    public void printProductNotFound() {
        System.out.println("Product not found");
    }

    public void printProduct(Product product) {
        System.out.println(product);
    }

    public void printTotalSum(double totalSum) {
        System.out.println("Total sum: " + totalSum);
    }
}
