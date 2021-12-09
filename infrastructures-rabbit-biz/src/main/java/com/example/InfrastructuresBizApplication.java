package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;


//@EnableEurekaClient
//@EnableHystrix
@Configuration
@Slf4j
@SpringBootApplication(scanBasePackages = "com.example.*")
public class InfrastructuresBizApplication {


    public static void main(String[] args) throws UnknownHostException {

        ConfigurableApplicationContext context = SpringApplication.run(InfrastructuresBizApplication.class, args);
        Environment environment = context.getBean(Environment.class);
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        log.info(" 访问地址: HTTP://{}:{}\t",hostAddress,environment.getProperty("server.port"));
    }
}
