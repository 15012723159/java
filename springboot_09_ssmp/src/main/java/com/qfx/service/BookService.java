package com.qfx.service;

import com.qfx.domain.Book;

import java.util.List;

public interface BookService {
    public boolean save(Book book);

    public Book getById(Integer id);

    public List<Book> selectList(String name);
}
