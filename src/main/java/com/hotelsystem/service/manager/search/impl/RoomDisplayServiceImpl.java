package com.hotelsystem.service.manager.search.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.RoomInfoBean;
import com.hotelsystem.dao.IReserveNumberDao;
import com.hotelsystem.dao.IRoomInfoDao;
import com.hotelsystem.service.manager.search.IRoomDisplayService;
@Service
public class RoomDisplayServiceImpl implements IRoomDisplayService{
	
	@Autowired
	private IRoomInfoDao roomInfoDao;
	@Autowired
	private IReserveNumberDao reserveNumberDao;
	
	@Override
	public PageInfo findAllRoomInfoByType(int pageNum,int type) {
		PageHelper.startPage(pageNum,12);
		List<RoomInfoBean> rooms=roomInfoDao.findRoomByType(type);
		PageInfo page=new PageInfo(rooms);
		return page;
	}

	@Override
	public int hasOrderCount(int type) {
		int count= reserveNumberDao.hasOrderCount(type);
		return count;
	}

	@Override
	public PageInfo findAllRoomInfo(int pageNum) {
		PageHelper.startPage(pageNum,12);
		List<RoomInfoBean> rooms=roomInfoDao.roomDisplayAll();
		PageInfo page=new PageInfo(rooms);
		return page;
	}
	

}
