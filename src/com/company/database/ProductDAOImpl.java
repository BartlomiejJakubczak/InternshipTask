package com.company.database;

import com.company.model.Product;

import java.util.Set;

public class ProductDAOImpl implements ProductDAO {

    private static ProductDAOImpl instance;

    private ProductDAOImpl() {
    }

    public static ProductDAOImpl getInstance() {
        if (instance == null) {
            synchronized (ProductDAOImpl.class) {
                instance = new ProductDAOImpl();
            }
        }
        return instance;
    }

    @Override
    public Set<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getProduct(double barcode) {
        return null;
    }
}
