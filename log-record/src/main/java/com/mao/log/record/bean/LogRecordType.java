package com.ydm.log.bean;

import lombok.Getter;

import java.util.Objects;

/**
 * @author myseital
 * @date 2022/8/19
 */
@Getter
public enum LogRecordType {

    MENU(0, "菜单"),
    ROLE(2, "角色"),
    USER(3, "用户"),
    ORDER(4, "订单"),
    SKU(5, "产品SKU"),
    STORE(6, "店铺"),
    INBOUND_ORDER(7, "入库单"),
    SHIP_ORDER(9, "发货单"),
    WMS_TRANSFER(10, "调拨单", LogRecordDB.WMS_TRANSFER),
    WMS_OUTBOUND(8, "出库单", LogRecordDB.WMS_OUTBOUND),
    ;

    /**
     * 类型
     */
    private final Integer code;
    /**
     * 描述
     */
    private final String module;

    /**
     *  数据源
     */
    private final LogRecordDB logRecordDB;

    LogRecordType(Integer code, String module) {
        this.code = code;
        this.module = module;
        this.logRecordDB = LogRecordDB.SYSTEM;
    }

    LogRecordType(Integer code, String module, LogRecordDB logRecordDB) {
        this.code = code;
        this.module = module;
        this.logRecordDB = logRecordDB;
    }

    public static String getModuleByCode(Integer code){
        for (LogRecordType logRecordType : LogRecordType.values()) {
            if (Objects.equals(logRecordType.getCode(), code)) {
                return logRecordType.getModule();
            }
        }
        return "";
    }

    public static LogRecordType geByCode(Integer code){
        for (LogRecordType logRecordType : LogRecordType.values()) {
            if (Objects.equals(logRecordType.getCode(), code)) {
                return logRecordType;
            }
        }
        return null;
    }
}
