package com.qfx.service.impl.rabbitmq.topic.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class RabbitMQDirectListner {
    @RabbitListener(queues = "topic_queue")
    public void receive(String id) {
        System.out.println("异步消费topic1="+id);
    }

    @RabbitListener(queues = "topic_queue2")
    public void receive2(String id) {
        System.out.println("异步消费topic2="+id);
    }
}
