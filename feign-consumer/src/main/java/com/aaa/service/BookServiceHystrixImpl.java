package com.aaa.service;

import com.aaa.model.BookInfo;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/12/4 8:31
 */
@Service
public class BookServiceHystrixImpl implements com.aaa.service.Service {
    @Override
    public List<BookInfo> getAllBook() {
        System.out.println("服务降级中");
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookName("水浒传");
        LinkedList<BookInfo> bookInfos = new LinkedList<>();
        bookInfos.add(bookInfo);
        return bookInfos;
    }
}
