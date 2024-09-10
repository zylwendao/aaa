/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.df;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author
 * @desc 程序主入口
 * @date 2024年07月27日22:45:34
 */
@SpringBootApplication
@MapperScan({"com.df.bac.dao", "com.df.web.dao"})
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}