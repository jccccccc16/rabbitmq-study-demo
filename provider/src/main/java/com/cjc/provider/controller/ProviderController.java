package com.cjc.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/3/16
 * Time: 16:51
 * To change this template use File | Settings | File Templates.
 **/
@RestController
@Slf4j
public class ProviderController {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send/direct")
    public String sendToDirect(@RequestParam("message") String message){

        log.info("我要发送");
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        rabbitTemplate.convertAndSend("directExchange01","queue01.apple",message+" Time: "+ time);
        String routingKey = rabbitTemplate.getRoutingKey();
        log.info("发送到routingKey："+ routingKey);
        return "发送成功,"+"发送到routingKey："+ routingKey;
    }

}
