package com.company.database;

import com.company.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private static volatile ProductDAOImpl instance;
    private List<Product> products;

    private ProductDAOImpl() {
        Product cheese = new Product("Cheese", 4.49, 111L);
        Product ham = new Product("Ham", 5.49, 222L);
        Product cannedPineapple = new Product("Canned Pineapple", 3.60, 333L);
        Product potatoChips = new Product( "Potato Chips", 6.99, 444L);
        products = new ArrayList<>();
        products.add(cheese);
        products.add(ham);
        products.add(cannedPineapple);
        products.add(potatoChips);
    }

    public static ProductDAOImpl getInstance() {
        if (instance == null) {
            synchronized (ProductDAOImpl.class) {
                if (instance == null) {
                    instance = new ProductDAOImpl();
                }
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
