package com.hotelsystem.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @ClassNmae IManagerRecordDao
 * @author Weizhengyi
 * @Descrption TODO
 * @Date 2018/8/4
 * @version 1.0
 */
import com.hotelsystem.bean.ManagerRecordBean;
import com.hotelsystem.bean.ViManagerLoginBean;
/**
 * @ClassNmae  IManagerRecordDao
 * @author Weizhengyi
 * @Descrption TODO
 * @Date 2018/8/4
 * @version 1.0
 */
public interface IManagerRecordDao {
	//查询所有
	public List<ManagerRecordBean> findAll();
	public ManagerRecordBean findIdbyManagerRecord(int id);
	//添加上班时间
	public void addupManagerRecord(ManagerRecordBean bean);
	//添加下班时间 
	public int addOffManagerRecord(ManagerRecordBean bean);
	//查看当天管理员工作日志
	public List<ViManagerLoginBean> findManagerRecordByDate(@Param("date")Date date,@Param("date2")Date date2);
	//查看全部管理员工作日志 
	public List<ViManagerLoginBean> findManagerRecord(int current);
}
