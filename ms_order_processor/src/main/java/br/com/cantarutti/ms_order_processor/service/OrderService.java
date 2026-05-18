package br.com.cantarutti.ms_order_processor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cantarutti.ms_order_processor.model.Order;
import br.com.cantarutti.ms_order_processor.model.OrderItem;
import br.com.cantarutti.ms_order_processor.repository.OrderRepository;

@Service
public class OrderService {
    
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) {
    if (order.getItems() != null && !order.getItems().isEmpty()) {
        for (OrderItem item : order.getItems()) {
            item.setOrder(order);
        }
    }
    return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

}
