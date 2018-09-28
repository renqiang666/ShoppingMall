package com.hotelsystem.service.manager.suppermanager;

import java.util.Date;
import java.util.List;

import com.hotelsystem.bean.HotelDiscountBean;
import com.hotelsystem.dao.IHotelDiscountDao;

/**
 * 全场折扣Service
 * @ClassName IOverTimeService
 * @Description XXX
 * @author Ren Qiang
 * @Date 2018/8/8 上午12:00
 * @version 1.0
 */
public interface IHotelDiscountService {
	/**
	 * 通过id修改全场折扣信息
	 * @MethodName updateDiscount
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/4 上午9:56
	 * @version 1.0
	 * @param startTime为新的全场折扣开始时间
	 * @param endTime为新的全场折扣结束时间
	 * @param value为新的折扣
	 * @param id为全场折扣id
	 * @return 返回是否修改成功
	 */
	String updateDiscount(Date startTime,Date endTime,Double value,int id);
	/**
	 * 添加新的全场折扣
	 * @MethodName addDiscount
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/8 上午10:00
	 * @version 1.0
	 * @param startTime为全场折扣开始时间
	 * @param endTime为全场折扣结束时间
	 * @param value为折扣
	 * @return 返回添加结果
	 */
	 String addDiscount(Date startTime, Date endTime, Double value);
	 /**
	 * 通过id删除该id对应的全场折扣
	 * @MethodName deleteDiscountById
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/8 下午10:02
	 * @version 1.0
	 * @param id
	 * @return 返回删除结果
	 */
	 String deleteDiscountById(int id);
	 /**
	 * 查询酒店所有有效的全场折扣
	 * @MethodName findAllDiscount
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/8 下午12:07
	 * @version 1.0
	 * @param id
	 * @return 返回所有的有效的全场折扣
	 */
	 List<HotelDiscountBean> findAllDiscount();
	 /**
	 * 查询当天是否有全场折扣
	 * @MethodName findDiscountByDate
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/8 下午2:29
	 * @version 1.0
	 * @return 如有折扣则返回折扣Bean，如无则返回null
	 */
	 HotelDiscountBean findDiscountByDate();
	 /**
	 * 查询指定日期是否有全场折扣
	 * @MethodName findDiscountByGivenDate
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/18 下午2:29
	 * @version 1.0
	 * @param stime指定开始日期
	 * @param etime指定结束日期
	 * @return 返回有无折扣
	 */
	 String findDiscountByGivenDate(Date stime,Date etime);
	 /**
	 * 查询指定日期除指定折扣外是否还有其他全场折扣
	 * @MethodName findDiscountByGivenDate
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/8 下午2:29
	 * @version 1.0
	 * @param stime指定开始日期
	 * @param etime指定结束日期
	 * @param id指定ID
	 * @return 返回有无折扣
	 */
	 String findDiscountByGivenDateAndId(Date stime,Date etime,int id);
}
