package com.qfx.service.impl.rabbitmq.direct;

import com.qfx.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageServiceRabbitmqImpl {
    @Autowired
    private AmqpTemplate amqpTemplate;


    //@Override
    public void sendMessage(String id) {
        log.info("订单进入队列2 id= "+ id );
        amqpTemplate.convertAndSend("direct_exchange", "direct",id);
        amqpTemplate.convertAndSend("direct_exchange", "direct2",id);
    }

   // @Override
    public String doMessage() {
        return "";
    }
}
