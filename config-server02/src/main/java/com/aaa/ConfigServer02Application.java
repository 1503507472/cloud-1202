package com.aaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/12/4 11:13
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigServer02Application {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer02Application.class);
    }
}
