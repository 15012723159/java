package com.qfx.controller;

import com.qfx.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {
    @Autowired
    private IMessageService messageService;

    @GetMapping("/create/{id}")
    public String create(@PathVariable String id) {
        log.info("订单处理业务开始"+id);
        messageService.sendMessage(id);
        return id;
    }
}
