package com.wang.service.impl;

import com.wang.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author xiaowang
 * @time 2020-12-18 14:07
 **/
@EnableBinding(Source.class)//定义消息的推送管道
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {

    //消息发送通道
    @Resource(name = "output")
    private MessageChannel output;

    @Override
    public String send() {
        String serial  = UUID.randomUUID().toString();
        log.info("生产者发送消息 ------> [{}]", serial);
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("生产者发送消息 ------> ", serial);
        return null;
    }
}
