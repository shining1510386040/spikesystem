package com.demo.springboot.storeservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.demo.springboot.storeservice.dao")
public class StoreserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreserviceApplication.class, args);
    }

}
