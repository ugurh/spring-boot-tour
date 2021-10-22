package com.example.introduction;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
@EnableEurekaClient
public class IntroductionApplication implements ApplicationRunner {

    /** Using default value if property name is not exist in application.yml */
    @Value("${spring.application.name:default_value}")
    private String applicationName;

    public static void main(String[] args) {
        SpringApplication.run(IntroductionApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println( applicationName + " from Application Runner");
    }
}
