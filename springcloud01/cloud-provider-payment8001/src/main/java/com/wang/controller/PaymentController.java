package com.wang.controller;

import com.wang.entities.CommonResult;
import com.wang.entities.Payment;
import com.wang.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.ognl.IteratorElementsAccessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private DiscoveryClient discoveryClient;

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
        log.info("8001");
        Payment result = paymentService.getPaymentById(id);
        log.info("*****查询结果："+result);
        if (result!=null){
            return new CommonResult(200,"查询成功,serverPort:"+serverPort,result);
        }
        return new CommonResult(404,"查询失败,serverPort:"+serverPort);
    }

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("****service:"+service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
            }
        }
        return discoveryClient;
    }

    @GetMapping("/timeOut")
    public CommonResult timeOut() throws InterruptedException {
        log.info("8001");
        Thread.sleep(3000);
        return new CommonResult(200,"用时3秒");
    }

    @GetMapping("/lb")
    public String getPaymentLb(){
        return serverPort;
    }

}
