package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.controller.req.BuriedPointStatistaReq;
import com.example.module.SecnResponse;
import com.example.service.RabbitProducerService;
import com.example.until.IpUtil;
import com.example.until.SecnResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.UNKNOWN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Random;


@Slf4j
@RestController
@RequestMapping("/producerController")
@Api("自建埋点上报服务Controller")
public class ProducerController {


    @Autowired
    private RabbitProducerService rabbitProducerService;

    @ResponseBody
    @PostMapping("/send")
    @ApiOperation(value = "生产者发送接口")
    public SecnResponse send(@RequestBody BuriedPointStatistaReq req,HttpServletRequest request) {

        /**
         * 一下为测试代码，这里主要完成参数校验
         */
       /*long aLong = RandomUtils.nextLong();
        BuriedPointStatistaReq req = new BuriedPointStatistaReq();
        req.setAid(String.valueOf(aLong));
        req.setCode(String.valueOf(aLong));
        req.setType("template");*/
        Long cts = Calendar.getInstance().getTimeInMillis() / 1000;
        req.setCts(cts.intValue());
        req.setIp(IpUtil.getRealIP(request));
        if(Objects.nonNull(req)) {
            if(StringUtils.isNotEmpty(req.getPn())){
                req.setPn(req.getPn().toLowerCase());
            }
        }
        Boolean aBoolean = rabbitProducerService.send(JSON.toJSONBytes(req));
        return SecnResponseUtil.ok(aBoolean);
    }



}
