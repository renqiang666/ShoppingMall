package com.hotelsystem.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName SerialBean
 * @Description TODO
 * @Author Wu Yimin
 * @Date 2018/8/8 上午10:47
 * @Version 1.0
 **/
public class SerialBean {
    private String seId;
    private String sePaidMoney;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date seArrDay;
    private String sePhone;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date seTimeNow;
    private String seDayNow;
    private String seConId;
    private Integer seCRoom;

    public Integer getSeCRoom() {
        return seCRoom;
    }

    public void setSeCRoom(Integer seCRoom) {
        this.seCRoom = seCRoom;
    }

    public String getSeId() {
        return seId;
    }

    public void setSeId(String seId) {
        this.seId = seId;
    }



    public String getSePaidMoney() {
        return sePaidMoney;
    }

    public void setSePaidMoney(String sePaidMoney) {
        this.sePaidMoney = sePaidMoney;
    }


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getSeArrDay() {
        return seArrDay;
    }

    public void setSeArrDay(Date seArrDay) {
        this.seArrDay = seArrDay;
    }

    public String getSePhone() {
        return sePhone;
    }

    public void setSePhone(String sePhone) {
        this.sePhone = sePhone;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getSeTimeNow() {
        return seTimeNow;
    }

    public void setSeTimeNow(Date seTimeNow) {
        this.seTimeNow = seTimeNow;
    }

    public String getSeDayNow() {
        return seDayNow;
    }

    public void setSeDayNow(String seDayNow) {
        this.seDayNow = seDayNow;
    }

    public String getSeConId() {
        return seConId;
    }

    public void setSeConId(String seConId) {
        this.seConId = seConId;
    }
}
