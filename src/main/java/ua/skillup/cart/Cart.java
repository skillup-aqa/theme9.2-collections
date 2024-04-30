package ua.skillup.cart;

public class Cart {
    /**
     * Add product to cart or increase quantity if product already in cart
     * @param product product name
     * @param quantity quantity of product
     */
    public void addProduct(String product, int quantity) {
        // implementation
    }

    /**
     * Remove product from cart
     * @param product product name
     * @throws IllegalArgumentException if product not found
     */
    public void setProductQuantity(String product, int quantity) {
        // implementation
    }

    /**
     * Remove product from cart
     * @param product product name
     * @return true if product was removed, false if product not found
     */
    public boolean removeProduct(String product) {
        // implementation
        return false;
    }

    /**
     * Get total price of all products in cart
     * @return total price
     */
    public double getTotalPrice() {
        // implementation
        return 0;
    }

    public String generateBill() {
        // implementation
        return "";
    }
}
