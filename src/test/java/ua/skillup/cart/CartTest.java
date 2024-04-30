package ua.skillup.cart;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CartTest {
    Cart cart;
    @BeforeMethod
    public void setUp() {
        cart = new Cart();
    }

    @Test
    public void testAddProduct() {
        cart.addProduct("apple", 2);
        String bill = cart.generateBill();
        assertTrue(bill.contains("apple"));
        assertTrue(bill.contains("2"));
    }

    @Test
    public void testRemoveProduct() {
        cart.addProduct("apple", 2);
        cart.removeProduct("apple");
        String bill = cart.generateBill();
        assertFalse(bill.contains("apple"));
        assertFalse(bill.contains("2"));
    }

    @Test
    public void testAddProductTwice() {
        cart.addProduct("apple", 2);
        cart.addProduct("apple", 3);
        String bill = cart.generateBill();
        assertTrue(bill.contains("apple"));
        assertTrue(bill.contains("5"));
    }

    @Test
    public void testSetProductQuantity() {
        cart.addProduct("apple", 2);
        cart.setProductQuantity("apple", 3);
        String bill = cart.generateBill();
        assertTrue(bill.contains("apple"));
        assertTrue(bill.contains("3"));
        assertFalse(bill.contains("2"));
    }

    @Test
    public void testSetProductQuantityForMissingProduct() {
        assertThrows(IllegalArgumentException.class, () -> cart.setProductQuantity("apple", 2));
    }

    @Test
    public void testRemoveProductNotFound() {
        assertFalse(cart.removeProduct("apple"));
    }


}
