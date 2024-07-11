package com.qfx.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    @GetMapping("/hello")
    public void  hello(){
        log.debug("hello world");
        log.info("hello world");
        log.error("hello world");
        log.warn("hello world");
        return;
    }
}
