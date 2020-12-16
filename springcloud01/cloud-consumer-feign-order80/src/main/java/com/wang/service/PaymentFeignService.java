package com.wang.service;

import com.wang.entities.CommonResult;
import com.wang.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaowang
 * @time 2020-12-09 15:55
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@RequestMapping("/payment")
public interface PaymentFeignService {

    @GetMapping("/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/timeOut")
    CommonResult timeOut() throws InterruptedException;

}
