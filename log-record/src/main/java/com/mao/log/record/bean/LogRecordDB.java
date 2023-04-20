package com.ydm.log.bean;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

/**
 * @author myseital
 * @date 2023/3/20
 */
@Getter
@RequiredArgsConstructor
public enum LogRecordDB {

    LOCAL(0, "本地日志"),
    SYSTEM(1, "系统日志"),
    WMS_TRANSFER(2, "调拨单管理"),
    WMS_OUTBOUND(3, "出库单管理"),

    ;

    /**
     * 类型
     */
    private final Integer code;
    /**
     * 描述
     */
    private final String module;

    public static LogRecordDB getByCode(Integer code){
        for (LogRecordDB recordDB : values()) {
            if (Objects.equals(recordDB.getCode(), code)) {
                return recordDB;
            }
        }
        return SYSTEM;
    }
}
