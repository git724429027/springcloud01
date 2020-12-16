package com.wang.controller;

import com.wang.entities.CommonResult;
import com.wang.entities.Payment;
import com.wang.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiaowang
 * @time 2020-12-09 16:08
 **/
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/payment/timeOut")
    public CommonResult timeOut() throws InterruptedException {
        return paymentFeignService.timeOut();
    }
}
