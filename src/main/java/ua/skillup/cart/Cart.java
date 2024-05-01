package ua.skillup.cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    /**
     * Add product to cart or increase quantity if product already in cart
     *
     * @param product  product name
     * @param quantity quantity of product
     */
    public void addProduct(Product product, int quantity) {
        this.items.stream().filter(item -> item.getProduct().equals(product))
                .findFirst()
                .ifPresentOrElse(item -> item.setQuantity(item.getQuantity() + quantity),
                        () -> this.items.add(new CartItem(product, quantity)));
    }

    /**
     * Set quantity of product in cart. Remove product if quantity is 0
     *
     * @param product product name
     * @throws IllegalArgumentException if product not found or quantity is less than 0
     */
    public void setProductQuantity(Product product, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity should be positive");
        }

        if (quantity == 0) {
            removeProduct(product);
            return;
        }

        this.items.stream()
                .filter(item -> item.getProduct().equals(product))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product not found"))
                .setQuantity(quantity);
    }

    /**
     * Remove product from cart
     *
     * @param product product name
     * @return true if product was removed, false if product not found
     */
    public boolean removeProduct(Product product) {
        return this.items.removeIf(item -> item.getProduct().equals(product));
    }

    /**
     * Get total price of all products in cart
     *
     * @return total price
     */
    public double getTotalPrice() {
        return this.items.stream()
                .mapToDouble(CartItem::getTotal)
                .sum();
    }

    public String generateBill() {
        StringBuilder bill = new StringBuilder();
        this.items.forEach(item -> bill.append(String.format("%s: %d x %.2f = %.2f\n",
                item.getProduct().getName(), item.getQuantity(), item.getProduct().getPrice(), item.getTotal())));
        bill.append(String.format("Total: %.2f", getTotalPrice()));
        return bill.toString();
    }

    private static class CartItem {
        private final Product product;
        private int quantity;

        public CartItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public double getTotal() {
            return product.getPrice() * quantity;
        }

        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
