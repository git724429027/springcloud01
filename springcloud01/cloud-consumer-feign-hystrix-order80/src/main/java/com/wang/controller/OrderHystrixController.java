package com.wang.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wang.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiaowang
 * @time 2020-12-15 11:40
 **/
@RestController
@Slf4j
@RequestMapping("/consumer/payment")
// @DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/hystrix/ok/{id}")
    // @HystrixCommand
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    }

    /*@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/
    // @HystrixCommand
    @GetMapping("/hystrix/timeOut/{id}")
    public String paymentInfo_timeOut(@PathVariable("id") Integer id){
        int i=10/0;
        return paymentHystrixService.paymentInfo_timeOut(id);
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "我是消费者：运行出错啦！  "+"paymentInfo_TimeOutHandler,id:"+id+"\t"+"┭┮﹏┭┮";
    }

    public String payment_Global_FallbackMethod(Integer id){
        return "我是默认方法：运行出错啦！  "+"payment_Global_FallbackMethod,id:"+id+"\t"+"┭┮﹏┭┮";
    }

}
