package com.company;

import com.company.controller.SaleController;
import com.company.view.LCDDisplay;
import com.company.view.Printer;

import java.util.Scanner;

public class Main {

    private static final String CLOSE_PROGRAM = "exit";

    public static void main(String[] args) {
        LCDDisplay lcdDisplayView = new LCDDisplay();
        Printer printerView = new Printer();
        SaleController saleController = new SaleController(printerView, lcdDisplayView);
        Scanner scanner = new Scanner(System.in);
        try {
            while(true) {
                saleController.printWaitingLine();
                String input = scanner.nextLine();
                if (input.equals(CLOSE_PROGRAM)) {
                    throw new IllegalStateException();
                }
                if (input.isEmpty()) {
                    saleController.printErrorEmpty();
                } else {
                    saleController.processInput(input);
                }
            }
        } catch(IllegalStateException e) {
            saleController.summariseShoppingList();
        }
    }
}
