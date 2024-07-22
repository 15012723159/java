package com.qfx.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
@Slf4j
public class BookController {
    @GetMapping("/hello")
    public String hello(){
        log.info("hello");
        log.info("hello");
        log.info("hello world");
        log.info("hello world2222");
        log.info("hello world2222");
        return "hello world";
    }
}
