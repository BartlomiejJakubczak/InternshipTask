package com.company.test;

import com.company.Main;
import com.company.controller.SaleController;
import com.company.database.ProductDAOImpl;
import com.company.model.Product;
import com.company.view.LCDDisplay;
import com.company.view.Printer;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.List;

public class TestSaleController {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private ProductDAOImpl databaseInstance = ProductDAOImpl.getInstance();
    private Printer printer = new Printer();
    private LCDDisplay lcdDisplay = new LCDDisplay();
    private SaleController controller;
    private List<Product> products = databaseInstance.getAllProducts();

    @BeforeEach
    public void initializeController() {
        controller = new SaleController(printer, lcdDisplay);
    }

    @BeforeEach
    public void setUpStream() {System.setOut(new PrintStream(outContent)); }

    @AfterEach
    public void restoreStream() {System.setOut(originalOut); }

    @Test
    public void testInputProcessing() {
        controller.processInput(String.valueOf(products.get(0).getBarcode()));
        controller.processInput(String.valueOf(products.get(0).getBarcode()));
        controller.processInput(Main.CLOSE_PROGRAM);
        BigDecimal actualResult = BigDecimal.valueOf(controller.getTotalSum());
        BigDecimal expectedResult = BigDecimal.valueOf(8.98);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testInputProcessingWithWrongBarcode() {
        controller.processInput(String.valueOf(products.get(1).getBarcode()));
        controller.processInput("123");
        controller.processInput(String.valueOf(products.get(0).getBarcode()));
        controller.processInput(Main.CLOSE_PROGRAM);
        BigDecimal actualResult = BigDecimal.valueOf(controller.getTotalSum());
        BigDecimal expectedResult = BigDecimal.valueOf(9.98);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testEmptyInput() {
        controller.processInput("");
        Assertions.assertTrue(controller.getProductsScanned().isEmpty());
    }

    @Test
    public void testEmptyInputOutput() {
        controller.processInput("");
        Assertions.assertEquals("Invalid bar-code", outContent.toString().trim());
    }

    @Test
    public void testImmediateExit() {
        controller.processInput(Main.CLOSE_PROGRAM);
        Assertions.assertTrue(controller.getProductsScanned().isEmpty());
    }

    @Test
    public void testWrongInput() {
        controller.processInput("123");
        Assertions.assertEquals("Product not found", outContent.toString().trim());
    }

}
