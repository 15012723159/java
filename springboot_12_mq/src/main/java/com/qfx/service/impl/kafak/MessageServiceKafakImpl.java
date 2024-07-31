package com.qfx.service.impl.kafak;

import com.qfx.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageServiceKafakImpl implements IMessageService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String id) {
        log.info("订单进入消息"+id);
        kafkaTemplate.send("qfx_topic", id);
    }

    @Override
    public String doMessage() {
        return "";
    }
}
