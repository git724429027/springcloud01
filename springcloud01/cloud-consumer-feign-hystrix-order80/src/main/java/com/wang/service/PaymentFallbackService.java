package com.wang.service;

import org.springframework.stereotype.Component;

/**
 * @author xiaowang
 * @time 2020-12-15 14:17
 **/
// @Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK*****";
    }

    @Override
    public String paymentInfo_timeOut(Integer id) {
        return "paymentInfo_timeOut*****";
    }
}
