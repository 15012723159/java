package com.qfx.controller;

import com.qfx.domain.Book;
import com.qfx.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController extends BaseController {

    @Autowired
    private IBookService bookService;
    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id){
        Log.debug("hello");
        Log.info("world");
        Log.warn("i");
        Log.error("error");
        Log.error("error1111");
        Log.error("error2222");
        Log.error("error3333");
        Log.info("hello world");
        Log.info("5555 world");
        Log.info("555566666 world");
        return bookService.getById(id);
    }
}
