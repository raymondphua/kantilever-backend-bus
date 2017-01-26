package com.infosupport.team2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
@Configuration
@EnableAutoConfiguration
public class BiIntegrationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BiIntegrationServiceApplication.class, args);
    }
}
