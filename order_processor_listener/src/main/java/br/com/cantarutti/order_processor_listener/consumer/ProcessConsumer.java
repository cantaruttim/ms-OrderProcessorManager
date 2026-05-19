package br.com.cantarutti.order_processor_listener.consumer;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cantarutti.order_processor_listener.model.Order;
import br.com.cantarutti.order_processor_listener.records.OrderRecord;
import br.com.cantarutti.order_processor_listener.repository.OrderRepository;

@Component
public class ProcessConsumer {
    
    private static final Logger logger = LoggerFactory.getLogger(ProcessConsumer.class);
    
    @Autowired
    private OrderRepository orderRepository;

    @RabbitListener(queues = "${broker.queue.processmanager.name}")
    public void listenerProcessQueue(OrderRecord orderRecord) {
        logger.info("Order Received: {}", orderRecord);
        System.out.println("Order Received: " + orderRecord.toString());
        
        try {
            // Processar a mensagem
            logger.debug("Processing message content: {}", orderRecord);

            System.out.println("Received OrderRecord: " + orderRecord);
        
            // Converter Record para Entity
            Order order = new Order(
                orderRecord.id(),
                orderRecord.description(),
                orderRecord.product(),
                orderRecord.quantity(),
                orderRecord.price()
            );
            
            orderRepository.save(order);
            System.out.println("Order saved! ID: " + order.getId());
            
        } catch (Exception e) {
            logger.error("Error processing message: {}", orderRecord, e);
        }
    }
}