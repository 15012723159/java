package com.qfx.service.impl.rabbitmq.topic.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RabbitMqDirect {

    @Bean
    public Queue queue() {
        return new Queue("topic_queue");
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topic_exchange",true,false);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(topicExchange()).with("order.*.id");
    }

    @Bean
    public Queue queue2() {
        return new Queue("topic_queue2");
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(topicExchange()).with("order.#");
    }


}
