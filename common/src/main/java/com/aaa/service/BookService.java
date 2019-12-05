package com.aaa.service;

import com.aaa.model.BookInfo;

import java.util.List;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/29 14:29
 */

public interface BookService {
    /**
     * 公共接口获取所有书籍
     * @return
     */
    List<BookInfo> getAllBook();
}
