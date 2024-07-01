package com.qfx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfx.dao.BookDao;
import com.qfx.domain.Book;
import com.qfx.service.IBookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
}
