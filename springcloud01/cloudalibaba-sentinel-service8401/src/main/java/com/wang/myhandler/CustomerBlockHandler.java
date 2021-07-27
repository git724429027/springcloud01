package com.wang.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wang.entities.CommonResult;
import com.wang.entities.Payment;

/**
 * @author xiaowang
 * @time 2020-12-23 11:36
 **/
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444, "按客户自定义限流测试Error,handlerException------1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444, "按客户自定义限流测试Error,handlerException---------2");
    }
}
