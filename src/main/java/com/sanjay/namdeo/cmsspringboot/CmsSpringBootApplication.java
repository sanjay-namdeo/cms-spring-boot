package com.sanjay.namdeo.cmsspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CmsSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsSpringBootApplication.class, args);
    }

}
