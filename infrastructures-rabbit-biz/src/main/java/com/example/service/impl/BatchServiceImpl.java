package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.example.convert.BuriedPointEntityTransfer;
import com.example.dto.BuriedPointEventDataDto;
import com.example.dto.BuriedPointStatistaDataDto;
import com.example.dto.BuriedPointStatistaReqDto;
import com.example.entity.IBuriedPointEventEntity;
import com.example.entity.IBuriedPointTemplateEntity;
import com.example.service.BatchService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BatchServiceImpl implements BatchService {

    private final String template ="template";

    private final String event ="event";

    @Autowired
    private BuriedRecordEventBatchService buriedRecordEventBatchService;

    @Autowired
    private BuriedRecordStatisticsBatchService buriedRecordStatisticsBatchService;

    @Override
    public void batchUpdateRecord(String jsonObject) {

        if(StringUtils.isNotEmpty(jsonObject)){
            JSONObject jsonResult = JSON.parseObject(jsonObject);
            BuriedPointStatistaReqDto buriedPointStatistaReqDto = jsonResult.toJavaObject(BuriedPointStatistaReqDto.class);
            String type = buriedPointStatistaReqDto.getType();
            JSONArray objects = buriedPointStatistaReqDto.getListJson();

            BuriedPointEntityTransfer instance = BuriedPointEntityTransfer.instance;

            if(template.equals(type)){
                if(CollectionUtils.isNotEmpty(objects)) {
                    List<BuriedPointStatistaDataDto> dataDtos = objects.toJavaList(BuriedPointStatistaDataDto.class);
                    List<IBuriedPointTemplateEntity> list = instance.convertBuriedPointStatistaEntity(dataDtos);
                    convertStatisticsEntity(buriedPointStatistaReqDto, list);
                    buriedRecordStatisticsBatchService.scheduleSaveStart(list);
                }else{
                    IBuriedPointTemplateEntity entity = instance.convertBuriedPointStatistaEntitys(buriedPointStatistaReqDto);
                    buriedRecordStatisticsBatchService.scheduleSaveStart(Arrays.asList(entity));
                }
            }if(event.equals(type)){
                if(CollectionUtils.isNotEmpty(objects)) {
                    List<BuriedPointEventDataDto> dataDtos = objects.toJavaList(BuriedPointEventDataDto.class);
                    List<IBuriedPointEventEntity> list = instance.convertBuriedPointEventEntity(dataDtos);
                    convertEventEntity(buriedPointStatistaReqDto, list);
                    buriedRecordEventBatchService.scheduleSaveStart(list);
                }else {
                    IBuriedPointEventEntity entity = instance.convertBuriedPointEventEntitys(buriedPointStatistaReqDto);
                    buriedRecordEventBatchService.scheduleSaveStart(Arrays.asList(entity));
                }
            }
        }

    }


    private void convertStatisticsEntity(BuriedPointStatistaReqDto buriedPointStatistaReqDto,List<IBuriedPointTemplateEntity> list) {
         if(CollectionUtils.isNotEmpty(list)){
            list.stream().forEach(iBuriedPointStatisticsEntity->{
                iBuriedPointStatisticsEntity.setCode(buriedPointStatistaReqDto.getCode());
                iBuriedPointStatisticsEntity.setCts(buriedPointStatistaReqDto.getCts());
                iBuriedPointStatisticsEntity.setPkg(buriedPointStatistaReqDto.getPkg());
                iBuriedPointStatisticsEntity.setChannel(buriedPointStatistaReqDto.getChannel());
                iBuriedPointStatisticsEntity.setPn(buriedPointStatistaReqDto.getPn());
                iBuriedPointStatisticsEntity.setIp(buriedPointStatistaReqDto.getIp());
                iBuriedPointStatisticsEntity.setPlatform(buriedPointStatistaReqDto.getPlatform());
                iBuriedPointStatisticsEntity.setAid(buriedPointStatistaReqDto.getAid());
                iBuriedPointStatisticsEntity.setGaid(buriedPointStatistaReqDto.getGaid());
                iBuriedPointStatisticsEntity.setUid(buriedPointStatistaReqDto.getUid());
                iBuriedPointStatisticsEntity.setTaurusStatUuid(buriedPointStatistaReqDto.getTaurusStatUuid());
            });
        }
    }

    private void convertEventEntity(BuriedPointStatistaReqDto buriedPointStatistaReqDto,List<IBuriedPointEventEntity> list) {
        if(CollectionUtils.isNotEmpty(list)){
            list.stream().forEach(iBuriedPointStatisticsEntity->{
                iBuriedPointStatisticsEntity.setCode(buriedPointStatistaReqDto.getCode());
                iBuriedPointStatisticsEntity.setCts(buriedPointStatistaReqDto.getCts());
                iBuriedPointStatisticsEntity.setPkg(buriedPointStatistaReqDto.getPkg());
                iBuriedPointStatisticsEntity.setChannel(buriedPointStatistaReqDto.getChannel());
                iBuriedPointStatisticsEntity.setPn(buriedPointStatistaReqDto.getPn());
                iBuriedPointStatisticsEntity.setIp(buriedPointStatistaReqDto.getIp());
                iBuriedPointStatisticsEntity.setPlatform(buriedPointStatistaReqDto.getPlatform());
                iBuriedPointStatisticsEntity.setAid(buriedPointStatistaReqDto.getAid());
                iBuriedPointStatisticsEntity.setGaid(buriedPointStatistaReqDto.getGaid());
                iBuriedPointStatisticsEntity.setUid(buriedPointStatistaReqDto.getUid());
                iBuriedPointStatisticsEntity.setTaurusStatUuid(buriedPointStatistaReqDto.getTaurusStatUuid());
            });
        }
    }
}
