package com.hotelsystem.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hotelsystem.bean.CheckInBean;
import com.hotelsystem.bean.ViewReserveRoomBean;

/**
 *@ClassName ICheckInDao
 *@Description TODO:
 *@Author Li Gen
 *@Date 2018年8月15日 上午11:15:53
 *@Version 1.0
 **/
public interface ICheckInDao {
	//查询所有入住
	List<CheckInBean> findAllCheckIn();
	//增加入住
	void insertCheckIn(CheckInBean bean);
	//移除入住
	int deleteCheckIn(String rid);
	//修改入住
	void updateCheckIn(int rid,int day,Date arrive,double money);
	//按房间号查询入住
	List<CheckInBean> findCheckInByRid(Integer roomId);
	/**
	 *	找到某一段时间类已经入住房间类型的数量，按类型记数
 	 */
	int findCheckInCountByTypeName(ViewReserveRoomBean bean);
    //获取所有房间号
	HashSet<Integer> findAllRoomId();
	/**
	 *
	 */
	CheckInBean findById(@Param("ci_id")String ci_id);

	/**
	 * 查询已经结账的订单
	 * @return
	 */
	List<CheckInBean> findExitCheckIn();
}

