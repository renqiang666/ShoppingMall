package com.hotelsystem.service.manager.suppermanager;

import java.util.Date;

import com.hotelsystem.bean.HotelOverTimeBean;

/**
 * 超时计费Service
 * @ClassName IOverTimeService
 * @Description XXX
 * @author Ren Qiang
 * @Date 2018/8/6 下午15:36
 * @version 1.0
 */
public interface IOverTimeService {
	/**
	 * 根据规定退房时间和实际退房时间的差值算出该多算几个半天的费用
	 * @MethodName countOverTime
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/6 下午15:41
	 * @version 1.0
	 * @param expectDate 表示规定的退房时间
	 * @param actualDate 表示实际的退房时间
	 * @return 返回超时收费
	 */
	 int countOverTime(Date expectDate,Date actualDate);
	 /**
	  * @MethodName findOverHalfDayStartTime
	  * @Description TODO
	  * @author Ren Qiang
	  * @Date 2018/8/6 下午17:04
	  * @version 1.0
	  * @return 返回规定退房时间
	  */
	  Date findOverHalfDayStartTime();
	  /**
	  * 返回超时收费规则
	  * @MethodName findHotelOverTimeRule
	  * @Description TODO
	  * @author Ren Qiang
	  * @Date 2018/8/6 下午17:04
	  * @version 1.0
	  * @return 返回超时收费Bean
	  */
	  HotelOverTimeBean findHotelOverTimeRule();
	  /**
	  * 计算超时收费
	  * @MethodName countOverTimeFee
	  * @Description TODO
	  * @author Ren Qiang
	  * @Date 2018/8/6 下午17:04
	  * @version 1.0
	  * @param expectDate 表示规定的退房时间
	  * @param actualDate 表示实际的退房时间
	  * @param typeName 表示入住的房间类型
	  * @param count 表示房间数量
	  * @return 返回规定退房时间
	  */
	  double countOverTimeFee(Date expectDate,Date actualDate,String typeName,int count);
	  /**
	  * 修改超时计费规则
	  * @MethodName updateOverTimeRule
	  * @Description TODO
	  * @author Ren Qiang
	  * @Date 2018/8/6 下午17:04
	  * @version 1.0
	  * @param newOverHalfDayStartTime 表示新的退房规定时间
	  * @param newOverAllDayStartTime 表示新的退房超过一天的规定时间
	  * @return 返回修改结果
	  */
	  String updateOverTimeRule(Date newOverHalfDayStartTime,Date newOverAllDayStartTime);
}
