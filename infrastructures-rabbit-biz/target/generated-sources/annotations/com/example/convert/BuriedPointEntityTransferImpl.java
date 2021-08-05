package com.example.convert;

import com.example.dto.BuriedPointEventDataDto;
import com.example.dto.BuriedPointStatistaDataDto;
import com.example.dto.BuriedPointStatistaReqDto;
import com.example.entity.IBuriedPointEventEntity;
import com.example.entity.IBuriedPointTemplateEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-02T16:59:20+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_192 (Oracle Corporation)"
)
public class BuriedPointEntityTransferImpl implements BuriedPointEntityTransfer {

    @Override
    public IBuriedPointTemplateEntity convertBuriedPointStatistaEntity(BuriedPointStatistaDataDto dataDtos) {
        if ( dataDtos == null ) {
            return null;
        }

        IBuriedPointTemplateEntity iBuriedPointTemplateEntity = new IBuriedPointTemplateEntity();

        iBuriedPointTemplateEntity.setAction( dataDtos.getAction() );
        iBuriedPointTemplateEntity.setRawData( dataDtos.getRawData() );
        iBuriedPointTemplateEntity.setTemplateId( dataDtos.getTemplateId() );
        iBuriedPointTemplateEntity.setTs( dataDtos.getTs() );

        return iBuriedPointTemplateEntity;
    }

    @Override
    public List<IBuriedPointTemplateEntity> convertBuriedPointStatistaEntity(List<BuriedPointStatistaDataDto> dataDtos) {
        if ( dataDtos == null ) {
            return null;
        }

        List<IBuriedPointTemplateEntity> list = new ArrayList<IBuriedPointTemplateEntity>( dataDtos.size() );
        for ( BuriedPointStatistaDataDto buriedPointStatistaDataDto : dataDtos ) {
            list.add( convertBuriedPointStatistaEntity( buriedPointStatistaDataDto ) );
        }

        return list;
    }

    @Override
    public IBuriedPointEventEntity convertBuriedPointEventEntity(BuriedPointEventDataDto dataDtos) {
        if ( dataDtos == null ) {
            return null;
        }

        IBuriedPointEventEntity iBuriedPointEventEntity = new IBuriedPointEventEntity();

        iBuriedPointEventEntity.setEventValue( dataDtos.getEventValue() );
        iBuriedPointEventEntity.setEventKey( dataDtos.getEventKey() );
        iBuriedPointEventEntity.setTs( dataDtos.getTs() );

        return iBuriedPointEventEntity;
    }

    @Override
    public List<IBuriedPointEventEntity> convertBuriedPointEventEntity(List<BuriedPointEventDataDto> dataDtos) {
        if ( dataDtos == null ) {
            return null;
        }

        List<IBuriedPointEventEntity> list = new ArrayList<IBuriedPointEventEntity>( dataDtos.size() );
        for ( BuriedPointEventDataDto buriedPointEventDataDto : dataDtos ) {
            list.add( convertBuriedPointEventEntity( buriedPointEventDataDto ) );
        }

        return list;
    }

    @Override
    public IBuriedPointTemplateEntity convertBuriedPointStatistaEntitys(BuriedPointStatistaReqDto buriedPointStatistaReqDto) {
        if ( buriedPointStatistaReqDto == null ) {
            return null;
        }

        IBuriedPointTemplateEntity iBuriedPointTemplateEntity = new IBuriedPointTemplateEntity();

        iBuriedPointTemplateEntity.setCode( buriedPointStatistaReqDto.getCode() );
        iBuriedPointTemplateEntity.setCts( buriedPointStatistaReqDto.getCts() );
        iBuriedPointTemplateEntity.setPkg( buriedPointStatistaReqDto.getPkg() );
        iBuriedPointTemplateEntity.setChannel( buriedPointStatistaReqDto.getChannel() );
        iBuriedPointTemplateEntity.setPn( buriedPointStatistaReqDto.getPn() );
        iBuriedPointTemplateEntity.setIp( buriedPointStatistaReqDto.getIp() );
        iBuriedPointTemplateEntity.setPlatform( buriedPointStatistaReqDto.getPlatform() );
        iBuriedPointTemplateEntity.setAid( buriedPointStatistaReqDto.getAid() );
        iBuriedPointTemplateEntity.setGaid( buriedPointStatistaReqDto.getGaid() );
        iBuriedPointTemplateEntity.setUid( buriedPointStatistaReqDto.getUid() );
        iBuriedPointTemplateEntity.setTaurusStatUuid( buriedPointStatistaReqDto.getTaurusStatUuid() );

        return iBuriedPointTemplateEntity;
    }

    @Override
    public IBuriedPointEventEntity convertBuriedPointEventEntitys(BuriedPointStatistaReqDto buriedPointStatistaReqDto) {
        if ( buriedPointStatistaReqDto == null ) {
            return null;
        }

        IBuriedPointEventEntity iBuriedPointEventEntity = new IBuriedPointEventEntity();

        iBuriedPointEventEntity.setCode( buriedPointStatistaReqDto.getCode() );
        iBuriedPointEventEntity.setCts( buriedPointStatistaReqDto.getCts() );
        iBuriedPointEventEntity.setPkg( buriedPointStatistaReqDto.getPkg() );
        iBuriedPointEventEntity.setChannel( buriedPointStatistaReqDto.getChannel() );
        iBuriedPointEventEntity.setPn( buriedPointStatistaReqDto.getPn() );
        iBuriedPointEventEntity.setIp( buriedPointStatistaReqDto.getIp() );
        iBuriedPointEventEntity.setPlatform( buriedPointStatistaReqDto.getPlatform() );
        iBuriedPointEventEntity.setAid( buriedPointStatistaReqDto.getAid() );
        iBuriedPointEventEntity.setGaid( buriedPointStatistaReqDto.getGaid() );
        iBuriedPointEventEntity.setTaurusStatUuid( buriedPointStatistaReqDto.getTaurusStatUuid() );
        iBuriedPointEventEntity.setUid( buriedPointStatistaReqDto.getUid() );

        return iBuriedPointEventEntity;
    }
}
