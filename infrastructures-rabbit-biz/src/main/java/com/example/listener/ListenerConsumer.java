package com.example.listener;


import com.example.config.MessagingConfig;
import com.example.service.BatchService;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class ListenerConsumer {

    @Autowired
    private BatchService batchService;

    @RabbitListener(queues =  MessagingConfig.QUEUE,concurrency = "10")
    public void onMessage(String msg, Channel channel, Message message) {


        long threadId = Thread.currentThread().getId();

        try {
            log.info("[onMessage][线程编号:{} 消息内容：{}]", threadId, msg);
            batchService.batchUpdateRecord(msg);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            log.error("[onMessage接收消息失败][线程编号:{} 异常内容：{}]",threadId,e.getMessage());
        }
    }
}
