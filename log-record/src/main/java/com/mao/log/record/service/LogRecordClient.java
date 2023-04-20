package com.ydm.log.service;

import com.ydm.log.bean.LogRecordDB;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author myseital
 * @date 2023/3/20
 */
@Slf4j
@RequiredArgsConstructor
public class LogRecordClient {

    private final List<ILogRecordService> logRecordServiceList;

    public ILogRecordService dispatchReport(LogRecordDB recordDB){
        for(ILogRecordService logRecordService : logRecordServiceList){
            if(logRecordService.recordDB().equals(recordDB)) {
                return logRecordService;
            }
        }
        log.error("log record db 异常 【{}】", recordDB.getCode());
        throw new RuntimeException("log record db 配置异常");
    }
}
