package com.liudao51.so.service.sprider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpriderService启动类
 */
@SpringBootApplication
@MapperScan("com.liudao51.so.service.sprider.mapper")
public class SpriderServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringApplication.class, args);
    }
}
