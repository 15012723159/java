package com.qfx.service.impl.rabbitmq.topic;

import com.qfx.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
@Slf4j
public class MessageServiceRabbitmqImpl  {
    //@Autowired
    private AmqpTemplate amqpTemplate;


    //@Override
    public void sendMessage(String id) {
        log.info("订单进入队列2 id= "+ id );
        amqpTemplate.convertAndSend("topic_exchange", "order.name.id",id);
    }

   // @Override
    public String doMessage() {
        return "";
    }
}
