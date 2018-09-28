

package com.hotelsystem.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

import com.hotelsystem.bean.SerialBean;

public interface ISerialDao {
	int insert(@Param("serialBean") SerialBean serialBean);

    int insertSelective(@Param("serialBean") SerialBean serialBean);

    int insertList(@Param("serialBeans") List<SerialBean> serialBeans);

    int update(@Param("serialBean") SerialBean serialBean);

    /**
     * 查询所有记录
     * @return
     */
    List<SerialBean> find();

    /**
     * 通过消费金额查询
     * @param sAmount
     * @return
     */
    List<SerialBean> findBySAmount(@Param("sAmount") Integer sAmount);

    /**
     * 删除小于某个时间的所有记录
     * @param minSTime
     * @return
     */
    int deleteBySTimeGreaterThanOrEqualTo(@Param("minSTime")Date minSTime);

    /**
     * 查询某个时间段的记录
     * @param minSTime
     * @param maxSTime
     * @return
     */
    List<SerialBean> findBySTimeGreaterThanOrEqualToAndSTimeLessThanOrEqualTo(@Param("minSTime")Date minSTime,@Param("maxSTime")Date maxSTime);
}
