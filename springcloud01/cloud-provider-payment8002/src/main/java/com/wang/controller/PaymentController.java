package com.wang.controller;

import com.wang.entities.CommonResult;
import com.wang.entities.Payment;
import com.wang.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xiaowang
 * @time 2020-12-08 13:31
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);
        if (result>0){
            return new CommonResult(200,"插入成功,serverPort:"+serverPort,result);
        }
        return new CommonResult(404,"插入失败,serverPort:"+serverPort,result);
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        log.info("8002");
        Payment result = paymentService.getPaymentById(id);
        log.info("*****查询结果："+result);
        if (result!=null){
            return new CommonResult(200,"查询成功,serverPort:"+serverPort,result);
        }
        return new CommonResult(404,"查询失败,serverPort:"+serverPort);
    }

    @GetMapping("/timeOut")
    public CommonResult timeOut() throws InterruptedException {
        log.info("8002");
        Thread.sleep(3000);
        return new CommonResult(200,"用时3秒");
    }

    @GetMapping("/lb")
    public String getPaymentLb(){
        return serverPort;
    }

}
