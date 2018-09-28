package com.hotelsystem.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hotelsystem.bean.HotelDiscountBean;
/**
 * 全场折扣Dao
 * @ClassName IHotelDiscountDao
 * @Description XXX
 * @author Ren Qiang
 * @Date 2018/8/4 上午9:39
 * @version 1.0
 */
public interface IHotelDiscountDao {
	/**
	 * 查询当天是否有全场折扣
	 * @MethodName findDiscountByDate
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/4 上午9:51
	 * @version 1.0
	 * @param nowadays 表示当前时间
	 * @return 如有折扣则返回折扣Bean，如无则返回null
	 */
	 HotelDiscountBean findDiscountByDate(Date nowadays);
	/**
	 * 通过id修改全场折扣信息
	 * @MethodName updateDiscount
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/4 上午9:56
	 * @version 1.0
	 * @param updateDiscount为新的全场折扣
	 * @param id为全场折扣id
	 * @return 返回受影响行数
	 */
	 int updateDiscount(@Param("bean")HotelDiscountBean newDiscountBean,@Param("id")int id );
	/**
	 * 添加新的全场折扣
	 * @MethodName addDiscount
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/4 上午10:00
	 * @version 1.0
	 * @param newDiscountBean 新的全场折扣
	 * @return 返回受影响行数
	 */
	 int addDiscount(HotelDiscountBean newDiscountBean);
	/**
	 * 通过id删除该id对应的全场折扣
	 * @MethodName deleteDiscountById
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/4 上午10:02
	 * @version 1.0
	 * @param id
	 * @return 返回受影响行数
	 */
	 int deleteDiscountById(int id);
	 /**
	 * 查询酒店所有有效的全场折扣
	 * @MethodName findAllDiscount
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/8 上午12:07
	 * @version 1.0
	 * @param id
	 * @return 返回受影响行数
	 */
	 List<HotelDiscountBean> findAllDiscount();
	 /**
	 * 更据日期段查询该段日期内是否已有折扣
	 * @MethodName findGivenTimeDiscount
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/18 下午14:32
	 * @version 1.0
	 * @param id
	 * @return 返回折扣List
	 */
	 List<HotelDiscountBean> findGivenTimeDiscount(@Param("stime")Date stime,@Param("etime")Date etime);

}
