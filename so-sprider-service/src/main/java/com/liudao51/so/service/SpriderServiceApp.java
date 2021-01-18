package com.liudao51.so.service;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpriderService启动类
 */
@SpringBootApplication
@MapperScan("com.liudao51.so.service.sprider.mapper")
@EnableDubbo  //开启扫描服务包(即扫描@Service注解)
public class SpriderServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(SpriderServiceApp.class, args);
    }
}
