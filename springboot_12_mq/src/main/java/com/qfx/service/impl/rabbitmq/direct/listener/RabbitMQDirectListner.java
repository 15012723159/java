package com.qfx.service.impl.rabbitmq.direct.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class RabbitMQDirectListner {
    //@RabbitListener(queues = "direct_queue")
    public void receive(String id) {
        System.out.println("异步消费direct="+id);
    }

   // @RabbitListener(queues = "direct_queue2")
    public void receive2(String id) {
        System.out.println("异步消费direct queue  2="+id);
    }
}
