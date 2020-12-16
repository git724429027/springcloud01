package com.wang.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaowang
 * @time 2020-12-08 12:58
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String  message;
    private T       data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
