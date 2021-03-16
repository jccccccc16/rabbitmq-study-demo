package com.cjc.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.amqp.core.Message;
/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/3/16
 * Time: 19:12
 * To change this template use File | Settings | File Templates.
 **/
@RestController
@Slf4j
public class TopiProviderController {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send/topic/{message}/{routingKey}")
    public String send(@PathVariable("message") String message,
                       @PathVariable("routingKey") String routingKey){

        log.info("我要发送了");
        log.info("message : "+ message);
        log.info("routingKey :"+routingKey);
        rabbitTemplate.convertAndSend("topicExchange", routingKey,message);

        return "发送完毕";


    }
}
