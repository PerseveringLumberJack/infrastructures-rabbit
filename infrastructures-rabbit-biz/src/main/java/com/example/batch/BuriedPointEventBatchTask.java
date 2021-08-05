package com.example.batch;


import com.example.entity.IBuriedPointEventEntity;
import com.example.service.BuriedPointEventService;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.Callable;

@Slf4j
public class BuriedPointEventBatchTask implements Serializable, Callable {



    private BuriedPointEventService buriedPointEventService;

    private Collection<IBuriedPointEventEntity> updates;

    public BuriedPointEventBatchTask(Collection<IBuriedPointEventEntity> updates,BuriedPointEventService buriedPointEventService) {
        this.updates = updates;
        this.buriedPointEventService = buriedPointEventService;
    }

    public BuriedPointEventBatchTask() {}


    /**
     * 保存
     * @return
     */
    private boolean batchSave() {
        try {
            log.info("[自建埋点上报数据]:批量保存开始.");
            return buriedPointEventService.saveBatch(updates);
        } catch (Exception e) {
            log.error("[自建埋点上报数据]保存异常.e:{}", e.getMessage(), e);
        }finally {
            log.info("[自建埋点上报数据]:批量保存完成.");
        }
        return Boolean.FALSE;

    }

    @Override
    public Object call() { return batchSave(); }
}
