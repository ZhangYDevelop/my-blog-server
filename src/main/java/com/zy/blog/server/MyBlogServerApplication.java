package com.zy.blog.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.zy.blog.server.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class MyBlogServerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MyBlogServerApplication.class, args);
    }
     // TODO tomcat war包部署时放开下面内容
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(MyBlogServerApplication.class);
//    }
}
