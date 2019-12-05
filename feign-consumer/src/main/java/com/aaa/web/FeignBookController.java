package com.aaa.web;

import com.aaa.model.BookInfo;
import com.aaa.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/12/2 16:28
 */
@RestController
public class FeignBookController {
    @Autowired
    private Service service;
    @GetMapping("feignGetAllBook")
    public List<BookInfo> getAllBook(){
        List<BookInfo> allBook = service.getAllBook();
        System.out.println("feignGetAllBook"+allBook.size());
        return  allBook;
    }
}
