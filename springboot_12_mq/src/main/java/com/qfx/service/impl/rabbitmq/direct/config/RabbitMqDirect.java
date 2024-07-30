package com.qfx.service.impl.rabbitmq.direct.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RabbitMqDirect {

    @Bean
    public Queue queue() {
        return new Queue("direct_queue");
    }

    @Bean
    public Queue queue2() {
        return new Queue("direct_queue2");
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct_exchange",true,false);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(directExchange()).with("direct");
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(directExchange()).with("direct2");
    }

}
