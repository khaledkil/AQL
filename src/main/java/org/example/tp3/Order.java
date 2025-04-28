package org.example.tp3;

public class Order {
    private long id;
    private String product;
    private int quantity;

    // Constructor
    public Order(long id, String product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}

