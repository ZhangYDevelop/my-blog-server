package com.zy.blog.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.zy.blog.server.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class MyBlogServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBlogServerApplication.class, args);
    }
}
