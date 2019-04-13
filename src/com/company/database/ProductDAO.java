package com.company.database;

import com.company.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();
    Product findByBarcode(long barcode);
}
