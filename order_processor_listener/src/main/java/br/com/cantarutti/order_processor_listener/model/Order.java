package br.com.cantarutti.order_processor_listener.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Order {

    @Id
    private UUID id;
    private String description;
    private String product;
    private int quantity;
    private double price;

    // Construtores
    public Order() {}
    
    public Order(UUID id, String description, String product, int quantity, double price) {
        this.id = id;
        this.description = description;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters e Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
