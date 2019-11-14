package com.cn.demo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description
 * @Author Wangbo
 * @Date 2019/11/14
 * @Version V1.0
 **/
@Service
public class RabbitListenerService {

    @RabbitListener(queues = "message.news")
    public void receiveMessage(Object map) {
        System.out.println("收到消息：\n" + map.toString());
    }
}
