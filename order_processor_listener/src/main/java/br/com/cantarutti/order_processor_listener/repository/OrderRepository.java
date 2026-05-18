package br.com.cantarutti.order_processor_listener.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cantarutti.order_processor_listener.model.Order;

public interface OrderRepository extends JpaRepository<Order, UUID> {}
