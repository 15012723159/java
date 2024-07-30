package com.qfx.service.impl.rocketmq;

import com.qfx.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageServiceRocketmqImpl implements IMessageService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendMessage(String id) {
        log.info("任务进入队列 id");
        rocketMQTemplate.convertAndSend("order_id",id);
    }

    @Override
    public String doMessage() {
        return "";
    }
}
