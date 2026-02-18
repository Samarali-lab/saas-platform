package com.saasplatform;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@EnableScheduling
public class SaasplatformApplication {
    public static void main(String[] args) {
        SpringApplication.run(SaasplatformApplication.class, args);
    }
}