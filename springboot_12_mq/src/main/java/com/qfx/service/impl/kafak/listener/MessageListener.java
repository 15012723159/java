package com.qfx.service.impl.kafak.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class MessageListener {
    @KafkaListener(topics = "qfx_topic")
    public void onMessage(ConsumerRecord<String, String> record) {
        System.out.println("异步处理kafak消息"+record.value());
    }
}
