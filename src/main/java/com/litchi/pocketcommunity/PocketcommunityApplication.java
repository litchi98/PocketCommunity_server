package com.litchi.pocketcommunity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@MapperScan("com.litchi.pocketcommunity.dao")
public class PocketcommunityApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Shanghai"));
        SpringApplication.run(PocketcommunityApplication.class, args);
    }

    @PostConstruct
    void setDefaultTimezone() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
    }

}
