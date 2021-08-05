package com.example.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

@Configuration
public class ThreadPoolConfig {


    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();


    @Bean
    public ExecutorService initThreadPoolExecutor(){
        return new ThreadPoolExecutor(1024, 2048,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(2048), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    }

}
