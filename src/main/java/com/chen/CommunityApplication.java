package com.chen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication()
@ServletComponentScan(basePackages = "com.chen.servlet")
public class CommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class, args);
        System.out.println("hello git");
        System.out.println("hello git2");
        System.out.println("hello git3");
        System.out.println("hello git4");
        System.out.println("hot-fix test1");
    }

}
