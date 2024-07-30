package com.qfx.service.impl;

import com.qfx.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.listener.endpoint.JmsMessageEndpointFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageServiceImpl{
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
   // @Override
    public void sendMessage(String id) {
        log.info("订单进入队列+ id = " + id);
        jmsMessagingTemplate.convertAndSend("order.queues.id",id);
    }

   // @Override
    public String doMessage() {
       String id =  jmsMessagingTemplate.receiveAndConvert("order.queue.id",String.class);
       log.info("订单id= " + id +"处理结束");
       return id;
    }
}
