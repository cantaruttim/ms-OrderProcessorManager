package br.com.cantarutti.ms_order_processor.controller;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cantarutti.ms_order_processor.model.Order;
import br.com.cantarutti.ms_order_processor.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final RabbitTemplate rabbitTemplate;
    private final OrderService orderService;

    public OrderController(OrderService orderService, RabbitTemplate rabbitTemplate) {
        this.orderService = orderService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.processmanager.name}")
    private String routingKey;

    @PostMapping
    public String createOrder(@RequestBody Order order) {
        Order orderSaved = orderService.saveOrder(order);
        rabbitTemplate.convertAndSend("", routingKey, orderSaved.getDescription());
        return "Order created successfully!" + order.getDescription();
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

}
