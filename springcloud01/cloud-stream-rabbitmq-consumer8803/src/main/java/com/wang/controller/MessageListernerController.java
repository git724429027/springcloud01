package com.wang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author xiaowang
 * @time 2020-12-20 17:52
 **/
@Component
@EnableBinding(Sink.class)
public class MessageListernerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String>message){
        System.out.println("消费者2号，-----》收到消息："+message.getPayload()+"\t"+"port:"+serverPort);
    }
}
