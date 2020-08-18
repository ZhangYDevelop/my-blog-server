package com.zy.blog.server;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.DigestUtils;

@MapperScan("com.zy.blog.server.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class MyBlogServerApplication extends SpringBootServletInitializer {

    private static  Logger logger = LoggerFactory.getLogger(MyBlogServerApplication.class);

    public static void main(String[] args) {
        logger.info("application start ...");
        SpringApplication.run(MyBlogServerApplication.class, args);
    }
}
