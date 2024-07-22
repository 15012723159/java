package com.qfx;

import com.qfx.domain.Book;
import com.qfx.domain.BookCase;
import com.qfx.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.client.match.ContentRequestMatchers;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//开启虚拟调用
@AutoConfigureMockMvc
@Slf4j
@Transactional
@Rollback(false)
public class WebTest {
    @Autowired
    private IBookService bookService;

    @Autowired
    private BookCase   bookCase;

    @Test
    void test() {

    }

    @Test
    void testWeb(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder bulider = MockMvcRequestBuilders.get("/books/getAll");
        ResultActions actions = mvc.perform(bulider);

        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();
        log.info(actions.andReturn().getResponse().getContentAsString());
        actions.andExpect(ok);
    }

    @Test
    void testFind(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder bulider = MockMvcRequestBuilders.get("/books/find");
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher contentJsn = content.json("{\"id\":1,\"name\":\"资治通鉴\",\"description\":\"宋代司马光2\",\"type\":\"历史1\"}");
        ResultActions actions = mvc.perform(bulider);
        actions.andExpect(contentJsn);
    }


    @Test
    void testDelete(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder bulider = MockMvcRequestBuilders.get("/books/delete");
        mvc.perform(bulider);
    }

    @Test
    void testHeadr(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder bulider = MockMvcRequestBuilders.get("/books/find");
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentJsn = header.string("content-type","application/jsons");

        ResultActions actions = mvc.perform(bulider);
        actions.andExpect(contentJsn);
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setDescription("hello");
        book.setType("物理23");
        book.setName("world");
        bookService.save(book);
    }

    @Test
    void testInsert(){
        log.info(bookCase.toString());
        Book   book = new Book();
        book.setName(bookCase.getName());
        book.setDescription(bookCase.getDescription());
        book.setType(bookCase.getType());
        bookService.save(book);
    }
}
