package com.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * rabbitmq service
 *
 * @author bingai
 */
@Component
@Slf4j
public class TreasureRabbitProducerService {


    @Autowired
    @Qualifier("treasureRabbitTemplate")
    private RabbitTemplate rabbitTemplate;



    public void convertAndSend(Object o, String exchange, String routing, String queue) {
        String msg = JSONObject.toJSONString(o);
        //默认不开启，当消息成功到达exchange的时候，发现没有绑定队列的回调，仅在出现问题时候触发
        rabbitTemplate.setReturnCallback(returnCallback);
        //默认不开启，用来确认消息是否到达exchange的回调
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.convertAndSend(exchange, routing, msg);

        // 插入发送记录表

        if(!Boolean.TRUE){
            log.info("save mq send record fail");
        }
    }

    private RabbitTemplate.ConfirmCallback confirmCallback = (correlationData, ack, cause) -> {
        if (!ack) {
            log.info("producer send message to exchange confirm callback error message id is {} reason is {} \t",
                    correlationData.getReturnedMessage().getMessageProperties().getMessageId(), cause);
        } else {
            log.info("producer send message to exchange confirm callback success message id is {} reason is {} \t",
                    correlationData.getReturnedMessage().getMessageProperties().getMessageId(), cause);
        }
    };

    private RabbitTemplate.ReturnCallback returnCallback = (message, replyCode, replyText, exchange, routingKey) -> {
        log.info("producer send message to exchange return callback error message id is {},consume tag id is{}\t",
                message, message.getMessageProperties().getConsumerTag());
    };

}
