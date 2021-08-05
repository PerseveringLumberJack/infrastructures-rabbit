package com.example.repository;

public interface RabbitTemplateRepository {

    void convertAndSend(Object o);
}
