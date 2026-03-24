package com.liefox;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.leifox.mapper")
public class HealthPunchSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthPunchSystemApplication.class, args);
    }

}
