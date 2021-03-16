package com.cjc.consumer.consume;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/3/16
 * Time: 17:02
 * To change this template use File | Settings | File Templates.
 **/
@Component
@Slf4j
public class RabbitMQConsumer {



    @RabbitListener(queues = {"queue01"})
    public void consumerBindedQueue01(String message){
        log.info("收到message为："+message);
    }


}
