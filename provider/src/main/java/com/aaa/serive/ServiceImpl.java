package com.aaa.serive;

import com.aaa.mapper.BookMapper;
import com.aaa.model.BookInfo;
import com.aaa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/29 14:45
 */
@Service
public class ServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<BookInfo> getAllBook() {
        List<BookInfo> bookInfos = bookMapper.getAllBook();
        System.out.println(bookInfos.size());
        return bookInfos;
    }
}
