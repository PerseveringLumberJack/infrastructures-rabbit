package com.example.service;

import java.util.List;

public interface BuriedRecordBatchService<T> {


     void scheduleSaveStart(List<T> entity);
}
