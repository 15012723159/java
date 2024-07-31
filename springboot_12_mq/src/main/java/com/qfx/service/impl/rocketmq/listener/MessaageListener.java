package com.qfx.service.impl.rocketmq.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
//@RocketMQMessageListener(topic = "order_sm_id",consumerGroup = "group-consume")
public class MessaageListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String id) {
        System.out.println("异步处理消息"+id);
    }
}
