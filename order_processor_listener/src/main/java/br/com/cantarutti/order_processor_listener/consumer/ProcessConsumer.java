package br.com.cantarutti.order_processor_listener.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProcessConsumer {
    
    private static final Logger logger = LoggerFactory.getLogger(ProcessConsumer.class);
    
    @RabbitListener(queues = "${broker.queue.processmanager.name}")
    public void listenerProcessQueue(@Payload String message) {
        logger.info("Received message: {}", message);
        System.out.println("Received message: " + message);
        
        try {
            // Processar a mensagem
            logger.debug("Processing message content: {}", message);
            
            // Aqui você pode adicionar sua lógica de negócio
            
        } catch (Exception e) {
            logger.error("Error processing message: {}", message, e);
        }
    }
}