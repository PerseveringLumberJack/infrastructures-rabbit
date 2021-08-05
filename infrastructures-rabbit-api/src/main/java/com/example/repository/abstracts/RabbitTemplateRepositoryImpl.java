package com.example.repository.abstracts;

import com.example.config.MessagingConfig;
import com.example.repository.RabbitTemplateRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class RabbitTemplateRepositoryImpl implements RabbitTemplateRepository {

    private static final int RABBITMQ_312_CODE = 312;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void convertAndSend(Object o) {
        //默认不开启，当消息成功到达exchange的时候，发现没有绑定队列的回调，仅在出现问题时候触发
        rabbitTemplate.setReturnCallback(returnCallback);
        //默认不开启，用来确认消息是否到达exchange的回调
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, o);
    }

    private RabbitTemplate.ConfirmCallback confirmCallback = (correlationData, ack, cause) -> {
        if (!ack) {
            log.info("producer send message to exchange confirm callback error message id is {} reason is {} \t" ,correlationData.getReturnedMessage().getMessageProperties().getMessageId(), cause);
        } else {
            log.info("producer send message to exchange confirm callback success message id is {} reason is {} \t",correlationData.getReturnedMessage().getMessageProperties().getMessageId(), cause);
        }
    };

    private RabbitTemplate.ReturnCallback returnCallback = (message, replyCode, replyText, exchange, routingKey) -> {
        log.info("producer send message to exchange return callback error message id is {},consume tag id is{}\t",message,message.getMessageProperties().getConsumerTag());
       /* log.error("消息主体 message : " + message);
        log.error("消息使用的consume tag:" + message.getMessageProperties().getConsumerTag());
        log.error("消息返回码 replyCode: " + replyCode);
        log.error("描述：" + replyText);
        log.error("消息使用的交换器 exchange : " + exchange);
        log.error("消息使用的路由键 routing : " + routingKey);*/
        /*if(replyCode == RABBITMQ_312_CODE){
            CompletableFuture.runAsync(()->{
                log.info("retry send message one more time when trigger ReturnCallback message");
                //rabbitTemplate.convertAndSend(exchange, routingKey, message.getBody());
                log.info("retry send message exchange is {}", exchange);
                log.info("retry send message routingKey is {}", routingKey);
                //log.info("retry send message body is {}", new String(message.getBody(), StandardCharsets.UTF_8));
            });
        }*/
    };
}
