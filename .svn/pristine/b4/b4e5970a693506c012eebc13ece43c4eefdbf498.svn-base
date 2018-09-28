package com.hotelsystem.service.manager.suppermanager;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.ManagerRecordBean;

/**
 * @ClassNmae IManagerRecordService
 * @author Weizhengyi
 * @Descrption TODO
 * @Date 2018/8/4
 * @version 1.0
 */
public interface IManagerRecordService {
	//显示所有工作日志
	public List<ManagerRecordBean> displayWorkLog();
	//记录上班时间并返回当前id
	public int punchIn(String name);
	//记录下班时间 
	public String punchOut(int id);
	//查看当天管理员工作日志
	public PageInfo findManagerRecordByDate(String date,int current);
	//查看全部管理员工作日志
	public PageInfo findAllManagerRecord(int current);

}
