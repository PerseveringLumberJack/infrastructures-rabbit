package com.example.service.impl;

import com.example.batch.BuriedPointEventBatchTask;
import com.example.entity.IBuriedPointEventEntity;
import com.example.service.BuriedPointEventService;
import com.example.service.BuriedRecordBatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BuriedRecordEventBatchService implements BuriedRecordBatchService {


    @Value("${batchSize}")
    private Integer batchSize;

    @Autowired
    private volatile ExecutorService executorService;

    @Autowired
    private BuriedPointEventService buriedPointEventService;

    private Lock lock = new ReentrantLock();

    private volatile Collection<IBuriedPointEventEntity> updates = new CopyOnWriteArrayList<>();

    @Override
    public void scheduleSaveStart(List entity) {

        log.info("[自建埋点上报数据]:定时线程GET开启。线程名称: {}", Thread.currentThread().getName());
        lock.lock();
        try {
            updates.addAll(entity);
            if (!updates.isEmpty() && batchSize<updates.size()) {
                if (!updates.isEmpty()) {
                    List<IBuriedPointEventEntity> tList = updates.stream().collect(Collectors.toList());
                    executorService.submit(new BuriedPointEventBatchTask(tList,buriedPointEventService));
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
