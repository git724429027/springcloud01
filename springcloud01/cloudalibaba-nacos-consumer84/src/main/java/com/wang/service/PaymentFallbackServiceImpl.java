package com.wang.service;

import com.wang.entities.CommonResult;
import com.wang.entities.Payment;
import org.springframework.stereotype.Service;

/**
 * @author Yang Hao
 * @date 2020-09-24 09:35
 */
@Service
public class PaymentFallbackServiceImpl implements PaymentService {
    @Override
    public CommonResult<Payment> PaymentSQL(Long id) {
        return new CommonResult<>(444444444, "服务降级返回，----PaymentFallbackServiceImpl", new Payment(id, "errorSerial"));
    }
}
