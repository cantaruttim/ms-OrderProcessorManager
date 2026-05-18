package br.com.cantarutti.order_processor_listener.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class RabbitMQConfig {

    @Value("${broker.queue.processmanager.name}")
    private String queueName;

    @Bean
    public Queue queue() {
        // queue name, durable, exclusive, autoDelete
        return new Queue(queueName, true, false, false);
    }
}