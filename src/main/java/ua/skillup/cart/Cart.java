package ua.skillup.cart;

public class Cart {
    /**
     * Add product to cart or increase quantity if product already in cart
     *
     * @param product  product name
     * @param quantity quantity of product
     */
    public void addProduct(Product product, int quantity) {
        // implementation
    }

    /**
     * Set quantity of product in cart. Remove product if quantity is 0
     *
     * @param product product name
     * @throws IllegalArgumentException if product not found or quantity is less than 0
     */
    public void setProductQuantity(Product product, int quantity) {
        // implementation
    }

    /**
     * Remove product from cart
     *
     * @param product product name
     * @return true if product was removed, false if product not found
     */
    public boolean removeProduct(Product product) {
        // implementation
        return false;
    }

    /**
     * Get total price of all products in cart
     *
     * @return total price
     */
    public double getTotalPrice() {
        // implementation
        return 0;
    }

    /**
     * Generate bill for all products in cart
     * Include product name, quantity, price per unit,
     * total price per product and total price for all products
     *
     * @return bill as string
     */
    public String generateBill() {
        // implementation
        return "";
    }
}
