package com.wang.controller;

import com.wang.entities.CommonResult;
import com.wang.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author xiaowang
 * @time 2020-12-08 14:33
 **/
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderConsulController {

    private static final String INVOKE_URL="http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/consul")
    public String paymentInfo(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
    }

}
