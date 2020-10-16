package com.weylau.javamyblogapi;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableApolloConfig
@EnableFeignClients(basePackages = { "com.weylau.javamyblogapi.remote" })
public class JavaMyblogApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaMyblogApiApplication.class, args);
    }

}
