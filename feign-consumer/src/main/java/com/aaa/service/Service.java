package com.aaa.service;

import com.aaa.model.BookInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/12/2 16:22
 */
@FeignClient(value = "provider-server",fallback = BookServiceHystrixImpl.class)
public interface Service {
    /**
     *得到所有书籍
     * @return
     */
    @GetMapping(value = "/getAllBook")
    List<BookInfo> getAllBook();

}
