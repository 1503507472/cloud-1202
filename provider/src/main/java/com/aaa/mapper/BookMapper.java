package com.aaa.mapper;

import com.aaa.model.BookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/29 14:46
 */
@Mapper
public interface BookMapper {
    /**
     * 拿到所有书籍
     * @return
     */
    @Select("select * from book_info")
    List<BookInfo> getAllBook();
}
