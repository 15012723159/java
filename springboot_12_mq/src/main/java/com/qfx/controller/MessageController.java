package com.qfx.controller;

import com.qfx.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msg")
@Slf4j
public class MessageController {
    @Autowired
    private IMessageService messageService;

    @GetMapping("/doMessage")
    public void doMessage(){
        log.info("处理订单开始");
        messageService.doMessage();

    }
}
