package com.hotelsystem.service.manager.suppermanager;

import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.CheckInBean;
import com.hotelsystem.bean.HotelDiscountBean;
import com.hotelsystem.bean.MenmbersBean;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ICheckInService
 * @Description TODO
 * @Author Wu Yimin
 * @Date 2018/8/9 下午2:40
 * @Version 1.0
 **/
public interface ICheckInService {
    /**
     * 查询所有房间号
     * @return
     */
    PageInfo queryAll(int pageNum);

    /**
     * 查询id入住信息
     */
    CheckInBean queryById(String id);

    double judgeMoeny(int overTime, double money, CheckInBean checkInBean, HotelDiscountBean hotelDiscountBean);

    String judgePaidMoney(MenmbersBean menmbersBean, String money,double lev);

    String judgeRes(MenmbersBean menmbersBean);

    double findLev(MenmbersBean menmbersBean);

    int deleteCheckIn(String ci_id);
}
