package com.example.tools.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    //@ConfigurationProperties(prefix = "spring.datasource.druid.one")
    @ConfigurationProperties(prefix = "spring.datasource.one")
    DataSource dsOne() {
        //return DruidDataSourceBuilder.create().build();
        return DataSourceBuilder.create().build();
    }
    /*
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.two")
    DataSource dsTwo() {
        return DataSourceBuilder.create().build();
    }
     */
}
