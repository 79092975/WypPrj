package com.wypprj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: Administrator
 * @DATE: 2023/10/19 15:36
 * @Description: 启动类
 * @Version: 1.0
 */

@SpringBootApplication
@MapperScan("com.wypprj.mapper")
@ComponentScan("com.wypprj.*")
public class WypPrjApplication {

    public static void main(String[] args) {
        System.out.println("main...");
        SpringApplication.run(WypPrjApplication.class, args);
    }

}
