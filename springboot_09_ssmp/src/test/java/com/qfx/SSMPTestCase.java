package com.qfx;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qfx.dao.BookDao;
import com.qfx.domain.Book;
import com.qfx.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SSMPTestCase {
    @Test
    void contextLoads() {
        System.out.println("helloi");
    }
    @Autowired
    private BookDao bookDao;

    @Autowired
    private IBookService bookService;

    /*@Test
    public void testSave() {
        Book book = new Book();
        book.setType("历史");
        book.setName("资治通鉴");
        book.setDescription("宋代司马光");
        bookDao.insert(book);

    }

    @Test
    public void testSelectPage(){
        IPage<Book> page = new Page<>(2,2);
        System.out.println(bookDao.selectPage(page,null));
    }

    @Test
    public void TestSelectList(){
        System.out.println(bookService.getById("1"));
    }*/
}
