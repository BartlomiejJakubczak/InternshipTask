package com.company.view;

import com.company.model.Product;

public class LCDDisplay {

    private final int LCDDisplayWidth = 38;

    public void printWaitingLine() {
        System.out.println(printBoundary());
        System.out.println("Waiting for barcode to scan...");
        System.out.println(printBoundary());
    }

    public void printErrorEmpty() {
        System.out.println(printBoundary());
        System.out.println("Invalid bar-code");
        System.out.println(printBoundary());
    }

    public void printProductNotFound() {
        System.out.println(printBoundary());
        System.out.println("Product not found");
        System.out.println(printBoundary());
    }

    public void printProduct(Product product) {
        System.out.println(printBoundary());
        System.out.println(product);
        System.out.println(printBoundary());
    }

    public void printTotalSum(double totalSum) {
        System.out.println(printBoundary());
        System.out.println("Total sum: " + totalSum);
        System.out.println(printBoundary());
    }

    private String printBoundary() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < LCDDisplayWidth; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
