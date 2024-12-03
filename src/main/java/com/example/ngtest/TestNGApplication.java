package com.example.ngtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.**")
public class TestNGApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestNGApplication.class, args);
    }

}
