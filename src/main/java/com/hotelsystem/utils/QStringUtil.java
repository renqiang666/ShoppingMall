package com.hotelsystem.utils;

/**
 * @ClassName QStringUtil
 * @Description TODO
 * @Author Wu Yimin
 * @Date 2018/8/6 下午5:56
 * @Version 1.0
 **/
public class QStringUtil {
    public static boolean isEmpty(String base64Code) {
        if ("null".equals(base64Code)){
        return true;
    }
        return false;
}
}
