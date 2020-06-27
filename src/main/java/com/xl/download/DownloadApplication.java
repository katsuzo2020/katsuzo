package com.xl.download;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value = "com.xl.download.mapper")
@SpringBootApplication
public class DownloadApplication {
    public static void main(String[] args) {
        SpringApplication.run(DownloadApplication.class, args);
    }

}
