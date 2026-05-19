package br.com.cantarutti.order_processor_listener.records;

import java.util.UUID;

import br.com.cantarutti.order_processor_listener.model.Order;

public record OrderRecord(
    UUID id,
    String product,
    int quantity,
    double price,
    String description
) {
    public static OrderRecord fromOrder(Order order) {
        return new OrderRecord(
            order.getId(),
            order.getProduct(),
            order.getQuantity(),
            order.getPrice(),
            order.getDescription()
        );
    }

    public Order toOrder() {
        return new Order(
            this.id,
            this.description,
            this.product,
            this.quantity,
            this.price
        );
    }
}
