package com.example.userapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@SpringBootApplication
@PropertySource(value = "classpath:application.properties")
public class UserApiApplication {

    public static void main(String... args) {
        SpringApplication.run(UserApiApplication.class, args);
    }

}
