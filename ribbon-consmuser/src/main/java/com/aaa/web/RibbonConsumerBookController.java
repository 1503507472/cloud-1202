package com.aaa.web;

import com.aaa.model.BookInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/12/2 15:28
 */
@RestController
public class RibbonConsumerBookController {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    @GetMapping("/getAllBook")
    public List<BookInfo> getAllBook(){
        LinkedList<BookInfo> forObject = restTemplate.getForObject("http://provider-server/getAllBook", LinkedList.class);
        return forObject;
    }
    public List<BookInfo> error(){
        System.out.println("服務熔斷");
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookName("西遊記");
        LinkedList<BookInfo> bookInfos = new LinkedList<>();
        bookInfos.add(bookInfo);
        return bookInfos;
    }
}
