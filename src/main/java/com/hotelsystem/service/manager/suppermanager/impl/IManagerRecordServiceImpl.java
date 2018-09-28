package com.hotelsystem.service.manager.suppermanager.impl;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.LevelDiscountBean;
import com.hotelsystem.bean.ManagerLoginBean;
import com.hotelsystem.bean.ManagerRecordBean;
import com.hotelsystem.dao.IManagerLoginDao;
import com.hotelsystem.dao.IManagerRecordDao;
import com.hotelsystem.bean.ViManagerLoginBean;
import com.hotelsystem.service.manager.suppermanager.IManagerRecordService;
@Service
public class IManagerRecordServiceImpl implements IManagerRecordService {
	@Autowired
	private IManagerRecordDao dao;
	@Autowired
	private IManagerLoginDao ldao;
	
	@Override
	public List<ManagerRecordBean> displayWorkLog() {
		
		return dao.findAll();
	}

	@Override
	public int punchIn(String name) {
		//获取当前登录管理员实体bean
		ManagerLoginBean bean= ldao.findNameByManager(name);
		//获取管理员工作日志实体bean
		ManagerRecordBean bean1=new ManagerRecordBean();
		//当用户登录时记录当前时间
		bean1.setMrOnTime(new Date());
		bean1.setMlb(bean);
		dao.addupManagerRecord(bean1);
		return bean1.getMrId();
	}

	@Override
	public String punchOut(int id) {
		String result="";
		//获取登录用户的工作日志实体bean
		ManagerRecordBean bean=dao.findIdbyManagerRecord(id);
		//当管理员注销时，更新下班时间
		bean.setMrOffTime(new Date());
		int re=dao.addOffManagerRecord(bean);
		if(re==1){
			result="下班打卡成功";
			
		}
		return result;
	}

	@Override
	public PageInfo findManagerRecordByDate(String date,int current) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		PageHelper.startPage(current,5);
		Date today=null;
		Date tomorrow=null;
		Calendar c;
		try {
			today=df.parse(date);
			 c= Calendar.getInstance();
			 c.setTime(today);
			 c.add(Calendar.DAY_OF_MONTH, 1);
			 tomorrow=c.getTime();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<ViManagerLoginBean> list=dao.findManagerRecordByDate(today,tomorrow);
		System.out.println(list);
		PageInfo page = new PageInfo(list);
		return page;
	}

	@Override
	public PageInfo findAllManagerRecord(int current) {
		PageHelper.startPage(current,5);
		List<ViManagerLoginBean> list=dao.findManagerRecord(current);
		PageInfo page = new PageInfo(list);
		return page;
	}

}
