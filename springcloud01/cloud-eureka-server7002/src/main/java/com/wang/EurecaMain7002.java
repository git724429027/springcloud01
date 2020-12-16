package com.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author xiaowang
 * @time 2020-12-08 15:55
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurecaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurecaMain7002.class,args);
    }
}
