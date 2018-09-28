package com.hotelsystem.utils;

/**
 * @ClassName OrderStatusEnum
 * @Description TODO
 * @Author Wu Yimin
 * @Date 2018/8/4 上午12:17
 * @Version 1.0
 **/
public enum OrderStatusEnum {
    WAIT_PAY("10", "待付款"),
    PAID("20", "已付款"),
    CANCELED("30", "已取消"),
    CLOSED("40", "交易关闭");

    public final String key;
    public final String value;

    OrderStatusEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getName(String key) {
        for (OrderStatusEnum status : OrderStatusEnum.values()) {
            if (status.getKey().equals(key)) {
                return status.value;
            }
        }
        return null;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}