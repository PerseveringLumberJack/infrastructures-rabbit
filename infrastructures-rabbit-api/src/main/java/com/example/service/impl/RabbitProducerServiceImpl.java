package com.example.service.impl;

import com.example.repository.RabbitTemplateRepository;
import com.example.service.RabbitProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RabbitProducerServiceImpl implements RabbitProducerService {


    @Autowired
    private RabbitTemplateRepository rabbitTemplateRepository;

    @Transactional
    public Boolean send(Object o) {
        /**
         * 消息发送成功可以在此保留发送记录
         */
        rabbitTemplateRepository.convertAndSend(o);
        return Boolean.TRUE;
    }
}
