package com.cjc.consumer.consume;

import com.cjc.consumer.config.TopicRabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/3/16
 * Time: 18:57
 * To change this template use File | Settings | File Templates.
 **/
@Component
@Slf4j
public class TopicConsumer {


    @RabbitListener(queues = "queue.man.no")
    public void manQueueHandler(String message){
        log.info("message: "+message);
        log.info("我是 man QueueHandler");
    }

    @RabbitListener(queues = "queue.woman.ok")
    public void womanQueueHandler(String message){
        log.info("message: "+message);
        log.info("我是 woman QueueHandler");
    }
}
