package com.company.database;

import com.company.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private static ProductDAOImpl instance;
    private List<Product> products;

    private ProductDAOImpl() {
        Product cheese = new Product(1, "Cheese", 4.49, 111111111111L);
        Product ham = new Product(2, "Ham", 5.49, 222222222222L);
        Product cannedPineapple = new Product(3, "Canned Pineapple", 3.60, 33333333333L);
        Product potatoChips = new Product(4, "Potato Chips", 6.99, 444444444444L);
        products = new ArrayList<>();
        products.add(cheese);
        products.add(ham);
        products.add(cannedPineapple);
        products.add(potatoChips);
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
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product findByBarcode(long barcode) {
        return products.stream()
                .filter(product -> barcode == product.getBarcode())
                .findAny()
                .orElse(null);
    }
}
