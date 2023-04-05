package com.txgc.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//启动类
@SpringBootApplication
@MapperScan("com.txgc.blog.dao.mapper")
public class BlogApp {
    public static void main(String[] args) {
        SpringApplication.run(BlogApp.class);
    }
}
