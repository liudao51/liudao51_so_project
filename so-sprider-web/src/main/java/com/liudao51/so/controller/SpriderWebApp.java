package com.liudao51.so.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * SpriderController启动类
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SpriderWebApp {
    public static void main(String[] args) {
        SpringApplication.run(SpriderWebApp.class, args);
    }
}
