/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package matresssales;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USER
 */


public class ProductTest {
    String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
    int[][] sales = {{25, 18, 20}, {15, 10, 12}, {18, 15, 20}};
    Product product = new Product(products, sales);

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectTotal() {
        assertEquals(153, product.GetTotalProductsSold());
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectAverage() {
        assertEquals(17.0, product.GetAverageProductSold(), 0.01);
    }

    @Test
    public void GetMostPopularProduct_WithValidData_ReturnsCorrectProduct() {
        assertEquals("Cozy Nights Monarch (25)", product.GetMostPopularProduct());
    }
}