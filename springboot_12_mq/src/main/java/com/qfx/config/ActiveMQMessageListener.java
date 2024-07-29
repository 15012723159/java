package com.qfx.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ActiveMQMessageListener {
    @JmsListener(destination = "order.queue.id")
    public void onMessage(String id) {

        log.info("业务已处理完成"+id);

    }
}
