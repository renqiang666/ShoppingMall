package com.hotelsystem.service.manager.search.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.SerialBean;
import com.hotelsystem.dao.ISerialDao;
import com.hotelsystem.service.manager.search.ISerialDisplayService;
@Service
public class SerialDisplaySerticeImpl implements ISerialDisplayService{
	@Autowired
	private ISerialDao serialDao;

	@Override
	public PageInfo findAll(int pageNum) {
		PageHelper.startPage(pageNum,8);
		List<SerialBean> serials=serialDao.find();
		PageInfo page=new PageInfo(serials);
		return page;
	}

	@Override
	public PageInfo findSerialByTime(int pageNum,Date startDate, Date endDate) {
		PageHelper.startPage(pageNum,6);
		List<SerialBean> serials=serialDao.findBySTimeGreaterThanOrEqualToAndSTimeLessThanOrEqualTo(startDate, endDate);
		PageInfo page=new PageInfo(serials);
		return page;
	}
	
}
