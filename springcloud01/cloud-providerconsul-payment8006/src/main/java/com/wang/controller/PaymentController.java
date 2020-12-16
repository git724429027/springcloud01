package com.wang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author xiaowang
 * @time 2020-12-09 11:42
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/consul")
    public String paymentConsul(){
        return "springcloud with consul: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
