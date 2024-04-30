package ua.skillup.cart;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        assertTrue(bill.contains(apple.getName()));
        assertTrue(bill.contains(apple.getPrice() + ""));
        assertTrue(bill.contains("42"));
    }

    @Test
    public void testRemoveProduct() {
        cart.addProduct(apple, 42);
        cart.removeProduct(apple);
        String bill = cart.generateBill();
        assertFalse(bill.contains(apple.getName()));
        assertFalse(bill.contains(apple.getPrice() + ""));
        assertFalse(bill.contains("42"));
    }

    @Test
    public void testAddProductTwice() {
        cart.addProduct(apple, 42);
        cart.addProduct(apple, 43);
        String bill = cart.generateBill();
        assertTrue(bill.contains("apple"));
        assertTrue(bill.contains("85"));
    }

    @Test
    public void testSetProductQuantity() {
        cart.addProduct(apple, 42);
        cart.setProductQuantity(apple, 43);
        String bill = cart.generateBill();
        assertTrue(bill.contains("apple"));
        assertTrue(bill.contains("85"));
        assertFalse(bill.contains("42"));
        assertFalse(bill.contains("43"));
    }

    @Test
    public void testSetProductQuantityForMissingProduct() {
        assertThrows(IllegalArgumentException.class, () -> cart.setProductQuantity(apple, 2));
    }

    @Test
    public void testRemoveProductNotFound() {
        assertFalse(cart.removeProduct(apple));
    }


}
