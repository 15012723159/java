package com.qfx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfx.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao  extends BaseMapper<Book> {
}
