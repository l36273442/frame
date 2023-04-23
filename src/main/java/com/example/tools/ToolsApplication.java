package com.example.tools;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class,})
//@MapperScan({"com.example.tools.dao", "com.example.tools.dao2"})
@SpringBootApplication
public class ToolsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ToolsApplication.class, args);
    }
}
