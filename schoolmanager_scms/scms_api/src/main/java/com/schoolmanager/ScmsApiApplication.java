package com.schoolmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.schoolmanager.*"})
@MapperScan("com.schoolmanager.dao")
public class ScmsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScmsApiApplication.class, args);
    }

}
