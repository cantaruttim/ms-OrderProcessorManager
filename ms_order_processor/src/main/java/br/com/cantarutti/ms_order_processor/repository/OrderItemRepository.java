package br.com.cantarutti.ms_order_processor.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cantarutti.ms_order_processor.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {
    
}
