package com.company;

import com.company.controller.SaleController;
import com.company.view.LCDDisplay;
import com.company.view.Printer;

import java.util.Scanner;

public class Main {

    public static final String CLOSE_PROGRAM = "exit";

    public static void main(String[] args) {
        LCDDisplay lcdDisplayView = new LCDDisplay();
        Printer printerView = new Printer();
        SaleController saleController = new SaleController(printerView, lcdDisplayView);
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            saleController.beginScanning();
            input = scanner.nextLine();
            saleController.processInput(input.trim());
        }
        while(!input.equals(CLOSE_PROGRAM));
    }
}
