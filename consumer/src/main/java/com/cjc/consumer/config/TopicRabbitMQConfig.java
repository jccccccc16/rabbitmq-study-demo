package com.cjc.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/3/16
 * Time: 18:57
 * To change this template use File | Settings | File Templates.
 **/
@Configuration
public class TopicRabbitMQConfig {

    public static String QUEUE_WOMAN = "queue.woman.ok";
    public static String QUEUE_MAN = "queue.man.no";

    @Bean
    public Queue queueMan(){
        return new Queue(QUEUE_MAN,true);
    }

    @Bean
    public Queue queueWoman(){
        return new Queue(QUEUE_WOMAN,true);
    }

    @Bean
    public Exchange topicExchange(){
        return ExchangeBuilder.topicExchange("topicExchange").build();
    }

    @Bean
    public Binding binding01(){
        return BindingBuilder.bind(queueMan()).to(topicExchange()).with("topic.man.*").noargs();

    }



    @Bean
    public Binding binding03(){
        return BindingBuilder.bind(queueWoman()).to(topicExchange()).with("topic.#").noargs();
    }

}
