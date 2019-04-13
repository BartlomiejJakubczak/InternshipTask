package com.company.database;

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

}
