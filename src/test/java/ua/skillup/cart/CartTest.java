package ua.skillup.cart;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

public class CartTest {
    Product apple = new Product("apple", 1.0);
    Product orange = new Product("orange", 2.0);

    Cart cart;


    @BeforeMethod
    public void setUp() {
        cart = new Cart();
    }

    @Test
    public void testAddProduct() {
        cart.addProduct(apple, 42);
        String bill = cart.generateBill();
        billShouldHaveProductInfo(bill, apple, 42);
    }

    @Test
    public void testAddTwoProducts() {
        cart.addProduct(apple, 42);
        cart.addProduct(orange, 43);
        String bill = cart.generateBill();
        billShouldHaveProductInfo(bill, apple, 42);
        billShouldHaveProductInfo(bill, orange, 43);
        billShouldHaveTotal(bill, 42 * apple.getPrice() + 43 * orange.getPrice());
    }

    @Test
    public void testAddSameProductTwoTimes() {
        cart.addProduct(apple, 42);
        cart.addProduct(apple, 43);
        String bill = cart.generateBill();
        billShouldHaveProductInfo(bill, apple, 85);
        billShouldHaveTotal(bill, 85 * apple.getPrice());
    }

    @Test
    public void testSetProductQuantity() {
        cart.addProduct(apple, 42);
        cart.setProductQuantity(apple, 43);
        String bill = cart.generateBill();
        billShouldHaveProductInfo(bill, apple, 43);
        billShouldHaveTotal(bill, 43 * apple.getPrice());
    }

    @Test
    public void testSetProductQuantityToZero() {
        cart.addProduct(apple, 42);
        cart.setProductQuantity(apple, 0);
        String bill = cart.generateBill();
        assertFalse(bill.contains(apple.getName()));
        assertFalse(bill.contains(String.format("%.2f", apple.getPrice())));
        assertFalse(bill.contains("42"));
        billShouldHaveTotal(bill, 0);
    }

    @Test
    public void testSetProductQuantityToNegative() {
        cart.addProduct(apple, 42);
        assertThrows(IllegalArgumentException.class, () -> cart.setProductQuantity(apple, -1));
    }

    @Test
    public void testSetProductQuantityForMissingProduct() {
        assertThrows(IllegalArgumentException.class, () -> cart.setProductQuantity(apple, 2));
    }

    @Test
    public void testRemoveProduct() {
        cart.addProduct(apple, 42);
        cart.removeProduct(apple);
        String bill = cart.generateBill();
        assertFalse(bill.contains(apple.getName()));
        assertFalse(bill.contains(String.format("%.2f", apple.getPrice())));
        assertFalse(bill.contains("42"));
        billShouldHaveTotal(bill, 0);
    }


    @Test
    public void testRemoveProductNotFound() {
        assertFalse(cart.removeProduct(apple));
    }

    @Test
    public void testGetTotalPrice() {
        cart.addProduct(apple, 42);
        cart.addProduct(orange, 43);
        assertEquals(cart.getTotalPrice(), 42 * apple.getPrice() + 43 * orange.getPrice());
    }

    void billShouldHaveProductInfo(String bill, Product product, int quantity) {
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(bill.contains(product.getName()));
        sa.assertTrue(bill.contains(quantity + ""));
        sa.assertTrue(bill.contains(String.format("%.2f", product.getPrice())));
        sa.assertTrue(bill.contains(String.format("%.2f", product.getPrice() * quantity)));
        sa.assertAll();
    }

    void billShouldHaveTotal(String bill, double total) {
        assertTrue(bill.contains(String.format("%.2f", total)));
    }


}
