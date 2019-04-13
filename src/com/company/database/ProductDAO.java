package com.company.database;

import com.company.model.Product;

import java.util.Set;

public interface ProductDAO {
    Set<Product> getAllProducts();
    Product getProduct(double barcode);
}
