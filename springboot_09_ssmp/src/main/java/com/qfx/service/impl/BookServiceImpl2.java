package com.qfx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qfx.dao.BookDao;
import com.qfx.domain.Book;
import com.qfx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl2 implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public boolean save(Book book) {
        return bookDao.insert(book) >0 ;
    }

    @Override
    public Book getById(Integer id) {

        return bookDao.selectById(id);
    }

    @Override
    public List<Book> selectList(String name) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Book::getName,name);
        return bookDao.selectList(lqw);
    }

}
