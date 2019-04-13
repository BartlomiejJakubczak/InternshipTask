package com.company.controller;

import com.company.Main;
import com.company.database.ProductDAOImpl;
import com.company.model.Product;
import com.company.view.LCDDisplay;
import com.company.view.Printer;

import java.util.ArrayList;
import java.util.List;

public class SaleController {

    private ProductDAOImpl database = ProductDAOImpl.getInstance();
    private Printer printerView;
    private LCDDisplay lcdDisplayView;
    private List<Product> productsScanned = new ArrayList<>();

    public SaleController(Printer printerView, LCDDisplay lcdDisplayView) {
        this.printerView = printerView;
        this.lcdDisplayView = lcdDisplayView;
    }

    public void beginScanning() {
        lcdDisplayView.printWaitingLine();
    }

    public void processInput(String input) {
        if (input.isEmpty()) {
            lcdDisplayView.printErrorEmpty();
        } else if (input.equals(Main.CLOSE_PROGRAM)) {
            summariseShoppingList();
        } else {
            Long barcode = Long.parseLong(input);
            Product product = database.findByBarcode(barcode);
            if (product == null) {
                lcdDisplayView.printProductNotFound();
            } else {
                lcdDisplayView.printProduct(product);
                productsScanned.add(product);
            }
        }
    }

    private void summariseShoppingList() {
        double totalSum = 0;
        for (Product product : productsScanned) {
            totalSum += product.getPrice();
        }
        lcdDisplayView.printTotalSum(totalSum);
        printerView.printShoppingList(productsScanned, totalSum);
    }

}
