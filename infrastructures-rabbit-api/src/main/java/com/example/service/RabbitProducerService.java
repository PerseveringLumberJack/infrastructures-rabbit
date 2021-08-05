package com.example.service;


public interface RabbitProducerService<T> {

    /**
     * 处理发送到消息队列
     * @param t 消息对象
     * @return 写入是否成功
     */
    Boolean send(T t);


}
