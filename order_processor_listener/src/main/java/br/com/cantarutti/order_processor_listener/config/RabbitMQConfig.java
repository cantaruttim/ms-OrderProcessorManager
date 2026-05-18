package br.com.cantarutti.order_processor_listener.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

import br.com.cantarutti.order_processor_listener.dto.OrderDTO;
import br.com.cantarutti.order_processor_listener.model.Order;
import br.com.cantarutti.order_processor_listener.repository.OrderRepository;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class RabbitMQConfig {

    @Autowired
    private OrderRepository orderRepository;

    @Value("${broker.queue.processmanager.name}")
    private String queueName;

    @Bean
    public Queue queue() {
        // queue name, durable, exclusive, autoDelete
        return new Queue(queueName, true, false, false);
    }

    @Bean
    public JacksonJsonMessageConverter jsonMessageConverter() {
        return new JacksonJsonMessageConverter();
    }

    @RabbitListener(queues = "${broker.queue.processmanager.name}")
    public void listenerProcessQueue(@Payload OrderDTO orderDTO) {
        System.out.println("Received OrderDTO: " + orderDTO);
        
        // Converter DTO para Entity
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setDescription(orderDTO.getDescription());
        
        // Salvar no banco de dados
        orderRepository.save(order);
        
        System.out.println("Order saved successfully! ID: " + order.getId());
    }

    
}