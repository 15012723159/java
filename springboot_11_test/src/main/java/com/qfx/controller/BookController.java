package com.qfx.controller;

import com.qfx.domain.Book;
import com.qfx.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
@Slf4j
public class BookController {

    @Autowired
    private IBookService bookService;
    @GetMapping("/getAll")
    public String findAll() {
        log.info("hello world");
        log.info("hello world");
        log.info("hello world3333");
        log.info("hello world33444");
        return "allsssss2223333333332fffffffffffsadfsafsadfsdfsff";
    }


    @GetMapping("/find")
    public Book find() {

       return bookService.getById(1);
    }


    @GetMapping("/delete")
    public String delete() {

        log.info("delete");
        return "allsssss2223333333332fffffffffffsadfsafsadfsdfsff";
    }
}
