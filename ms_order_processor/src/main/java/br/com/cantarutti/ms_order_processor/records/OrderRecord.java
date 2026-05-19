package br.com.cantarutti.ms_order_processor.records;

import java.util.List;
import java.util.UUID;

import br.com.cantarutti.ms_order_processor.model.OrderItem;

public record OrderRecord(
    UUID id,
    String product,
    int quantity,
    double price,
    String description,
    List<OrderItem> items
) {}
