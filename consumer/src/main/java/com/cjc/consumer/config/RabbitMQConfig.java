package com.cjc.consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/3/16
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 **/
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue queue01(){
        return new Queue("queue01",true);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange01",true,false);
    }

    @Bean
    public Binding directExchangeQueue01(){
        return  BindingBuilder.bind(queue01()).to(directExchange()).with("queue01.apple");

    }



}
