package com.qfx.service.impl.rocketmq;

import com.qfx.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
@Slf4j
public class MessageServiceRocketmqImpl  {

    //@Autowired
    private RocketMQTemplate rocketMQTemplate;

    //@Override
    public void sendMessage(String id) {
        log.info("任务进入队列 id");
        SendCallback callback = new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("异步成功回调");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println(throwable.getMessage());
                System.out.println("异步失败回调");

            }
        };
        //rocketMQTemplate.convertAndSend("order_sm_id",id);
        rocketMQTemplate.asyncSend("order_sm_id",id,callback);
    }

    //@Override
    public String doMessage() {
        return "";
    }
}
