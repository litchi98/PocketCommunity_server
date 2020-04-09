package com.litchi.pocketcommunity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.litchi.pocketcommunity.dao")
public class PocketcommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(PocketcommunityApplication.class, args);
    }

}
