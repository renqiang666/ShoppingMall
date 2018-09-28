package com.hotelsystem.dao;


import com.hotelsystem.bean.HotelOverTimeBean;

/**
 * 超时计费Dao
 * @ClassName IHotelOverTimeDao
 * @Description XXX
 * @author Ren Qiang
 * @Date 2018/8/4 上午10:04
 * @version 1.0
 */
public interface IHotelOverTimeDao {
	/**
	 * 查询酒店的超时计费规则
	 * @MethodName findHotelOverTimeRule
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/4 上午10:06
	 * @version 1.0
	 * @return 返回计费规则HotelOverTimeBean
	 */
 public HotelOverTimeBean findHotelOverTimeRule();
	 /**
	  * 修改退房时间规定
	  * @MethodName updateOverTimeRule
	  * @Description TODO
	  * @author Ren Qiang
	  * @Date 2018/8/4 上午10:09
	  * @version 1.0
	  * @param bean 新的退房时间规定
	  * @return 返回受影响行数
	  */
 public int updateOverTimeRule(HotelOverTimeBean bean);
}
