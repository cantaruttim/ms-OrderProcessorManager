package br.com.cantarutti.order_processor_listener.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
// import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.cantarutti.order_processor_listener.dto.OrderDTO;

@Component
public class ProcessConsumer {
    
    private static final Logger logger = LoggerFactory.getLogger(ProcessConsumer.class);
    
    @RabbitListener(queues = "${broker.queue.processmanager.name}")
    public void listenerProcessQueue(OrderDTO orderDTO) {
        logger.info("Order Received: {}", orderDTO);
        System.out.println("Order Received: " + orderDTO.toString());
        
        try {
            // Processar a mensagem
            logger.debug("Processing message content: {}", orderDTO);
            
            // Aqui você pode adicionar sua lógica de negócio
            
        } catch (Exception e) {
            logger.error("Error processing message: {}", orderDTO, e);
        }
    }
}