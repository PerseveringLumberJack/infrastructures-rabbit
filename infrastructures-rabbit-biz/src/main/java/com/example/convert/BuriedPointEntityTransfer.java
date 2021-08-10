package com.example.convert;

import com.example.dto.BuriedPointEventDataDto;
import com.example.dto.BuriedPointStatistaDataDto;
import com.example.dto.BuriedPointStatistaReqDto;
import com.example.entity.IBuriedPointEventEntity;
import com.example.entity.IBuriedPointTemplateEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BuriedPointEntityTransfer {


    BuriedPointEntityTransfer instance = Mappers.getMapper(BuriedPointEntityTransfer.class);


    /**
     * 后续一一指定参数的映射关系
     * @param
     * @return
     */
    @Mappings({
            @Mapping(target = "ts",source = "dataDtos.ts"),
            @Mapping(target = "action", source = "dataDtos.action"),
            @Mapping(target = "templateId",source = "dataDtos.templateId"),
            @Mapping(target = "rawData",source = "dataDtos.rawData"),
            @Mapping(target = "sharePlatform",source = "dataDtos.sharePlatform")
    })
    IBuriedPointTemplateEntity convertBuriedPointStatistaEntity(BuriedPointStatistaDataDto dataDtos);



    List<IBuriedPointTemplateEntity> convertBuriedPointStatistaEntity(List<BuriedPointStatistaDataDto> dataDtos);

    @Mappings({
            @Mapping(target = "ts",source = "dataDtos.ts"),
            @Mapping(target = "eventKey", source = "dataDtos.eventKey"),
            @Mapping(target = "eventValue",source = "dataDtos.eventValue")
    })
    IBuriedPointEventEntity convertBuriedPointEventEntity(BuriedPointEventDataDto dataDtos);


    List<IBuriedPointEventEntity> convertBuriedPointEventEntity(List<BuriedPointEventDataDto> dataDtos);


    IBuriedPointTemplateEntity convertBuriedPointStatistaEntitys(BuriedPointStatistaReqDto buriedPointStatistaReqDto);

    IBuriedPointEventEntity convertBuriedPointEventEntitys(BuriedPointStatistaReqDto buriedPointStatistaReqDto);
}
