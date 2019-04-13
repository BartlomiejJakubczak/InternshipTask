package com.company.model;

public class Product {

    private String name;
    private int price;
    private double barcode;

    public Product(String name, int price, double barcode) {
        this.name = name;
        this.price = price;
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getBarcode() {
        return barcode;
    }

    public void setBarcode(double barcode) {
        this.barcode = barcode;
    }
}
