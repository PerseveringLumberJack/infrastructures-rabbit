package com.example.batch;


import com.example.entity.IBuriedPointTemplateEntity;
import com.example.service.BuriedPointStatisticsService;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.Callable;

@Slf4j
public class BuriedPointStatisticsBatchTask implements Serializable, Callable {



    private BuriedPointStatisticsService buriedPointStatisticsService;

    private Collection<IBuriedPointTemplateEntity> updates;

    public BuriedPointStatisticsBatchTask(Collection<IBuriedPointTemplateEntity> update, BuriedPointStatisticsService buriedPointStatisticsService) {
        this.updates = update;
        this.buriedPointStatisticsService = buriedPointStatisticsService;
    }


    private boolean batchSave() {
        try {
            log.info("[自建埋点上报数据]:批量保存开始.");
            return buriedPointStatisticsService.saveBatch(updates);
        } catch (Exception e) {
            log.error("[自建埋点上报数据]保存异常.e:{}", e.getMessage(), e);
        }finally {
            log.info("[自建埋点上报数据]:批量保存完成.");
        }
        return Boolean.FALSE;

    }

    @Override
    public Object call() { return batchSave(); }

    public BuriedPointStatisticsBatchTask() {}
}
