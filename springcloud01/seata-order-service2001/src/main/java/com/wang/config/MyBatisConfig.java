package com.wang.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yang Hao
 * @date 2020-09-27 11:49
 */
@Configuration
@MapperScan("com.wang.dao")
public class MyBatisConfig {
}
