package com.wang.service;

import com.wang.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiaowang
 * @time 2020-12-08 13:26
 **/
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
