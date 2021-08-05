package com.example.service.impl;

import com.example.batch.BuriedPointStatisticsBatchTask;
import com.example.entity.IBuriedPointTemplateEntity;
import com.example.service.BuriedPointStatisticsService;
import com.example.service.BuriedRecordBatchService;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
@Slf4j
public class BuriedRecordStatisticsBatchService implements BuriedRecordBatchService {

    @Value("${batchSize}")
    private Integer batchSize;

    @Autowired
    private volatile MapperFacade mapperFacade;

    @Autowired
    private volatile ExecutorService executorService;

    private Lock lock = new ReentrantLock();

    private volatile Collection<IBuriedPointTemplateEntity> updates = new CopyOnWriteArrayList<>();

    @Autowired
    private BuriedPointStatisticsService buriedPointStatisticsService;

    @Override
    public void scheduleSaveStart(List entity) {

        log.info("[自建埋点上报数据]:定时线程GET开启。线程名称: {}", Thread.currentThread().getName());
        lock.lock();
        try {
            updates.addAll(entity);
            if (!updates.isEmpty() && batchSize<updates.size()) {
                if (!updates.isEmpty()) {
                    Collection<IBuriedPointTemplateEntity> tList = mapperFacade.mapAsList(updates, IBuriedPointTemplateEntity.class);
                    executorService.submit(new BuriedPointStatisticsBatchTask(tList,buriedPointStatisticsService));
                    updates.clear();
                }
            }
        } catch (Exception e) {
            log.error("[自建埋点上报数据]:定时线程GET异常:e:{}", e.getMessage(), e);
        }finally {
            lock.unlock();
        }
    }

}
