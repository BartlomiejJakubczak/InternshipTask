package com.company.model;

public class Product {

    private int id;
    private String name;
    private double price;
    private long barcode;

    public Product(int id, String name, double price, long barcode) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Name of product: " + this.getName() + "\n" +
                "Price of product: " + this.getPrice() + "\n" +
                "Barcode of product: " + this.getBarcode() + "\n";
    }
}
