package com.hotelsystem.service.manager.checkin;

import java.util.List;

import com.hotelsystem.bean.CheckInBean;
import com.hotelsystem.bean.HotelDiscountBean;
import com.hotelsystem.bean.MenmbersBean;

/**
 * @ClassName ICheckInService
 * @Description TODO:
 * @Author Li Gen
 * @Date 2018年8月15日 上午11:23:14
 * @Version 1.0
 **/
public interface ICheckInService {
	// 查询所有入住信息
	List<CheckInBean> findAll();

	// 通过房间号查询入住信息
	List<CheckInBean> findCheckInByRid(Integer rid);

	// 增加入住信息
	void addCheckIn(CheckInBean bean);

	// 延期入住
	void extend(int roomId, int day, double payMoney);
	
	//计算房价
	double colPrice(int roomId,int day);
	
	/**
     * 查询入住id入住信息
     */
    CheckInBean queryById(String id);
    
    double judgeMoeny(int overTime, double money, CheckInBean checkInBean, HotelDiscountBean hotelDiscountBean);

    String judgePaidMoney(MenmbersBean menmbersBean, String money,double lev);

    String judgeRes(MenmbersBean menmbersBean);

    double findLev(MenmbersBean menmbersBean);

    int deleteCheckIn(String ci_id);

}
