package com.hotelsystem.service.user.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

import com.hotelsystem.bean.LevelDiscountBean;
import com.hotelsystem.bean.MenmbersBean;
import com.hotelsystem.bean.RoomTypeBean;
import com.hotelsystem.bean.ViewReserveRoomBean;
import com.hotelsystem.dao.ICheckInDao;
import com.hotelsystem.dao.ILevelDiscountDao;
import com.hotelsystem.dao.IMenmbersDao;
import com.hotelsystem.dao.IReserveNumberDao;
import com.hotelsystem.dao.IReserveRoomDao;
import com.hotelsystem.dao.IRoomInfoDao;
import com.hotelsystem.dao.IRoomTypeDao;
import com.hotelsystem.service.user.IRoomTypeService;

@Service
public class UserRoomTypeServiceImpl implements IRoomTypeService {
	@Autowired
	private IRoomTypeDao roomTypeDao;
	@Autowired
	private ILevelDiscountDao levelDiscountDao;
	@Autowired
	private IRoomInfoDao roomInfoDao;
	@Autowired
	private IReserveRoomDao reserveRoomDao;
	@Autowired
	private IReserveNumberDao reserveNumberDao;
	@Autowired
	private IMenmbersDao memberDao;
	@Autowired
	private ICheckInDao checkDao;
	
	@Override
	public List<RoomTypeBean> getRoomType() {
		// 获取所有的房间类型
		List<RoomTypeBean> roomTypeList = roomTypeDao.findRoomType();
		return roomTypeList;
	}

	@Override
	public Map<String, Object> getPriceMap(int id) {
	
		// 获取所有会员折扣
		List<LevelDiscountBean> levelList = levelDiscountDao.checkLevelDiscount();
		//所预订的房间类型信息
		RoomTypeBean roomTypeBean = roomTypeDao.findRoomTypeById(id);
	
		int reserve = reserveNumberDao.hasOrderCount(id);
		int checkIn = roomInfoDao.findAllRoomInfoCountByType(id);

		Map<String, Object> map = new HashMap<String, Object>();
		// 将会员折扣信息放入到map中
		map.put("list", levelList);
		map.put("roomTypeBean", roomTypeBean);
		map.put("restRoom",checkIn-reserve);
		return map;
	}

	@Override		
	public int availableRoomNumber(ViewReserveRoomBean bean) {
		// 该类型房间所有的数量
		int total = roomInfoDao.findSpecialRoomInfoCountByType(bean.getRoomTypeId());
		// 预定表中查找该类型房间已经被预定的数量
		int reserveCount = reserveRoomDao.findReserveCountByTypeName(bean);
		//当前时间段查找该类型房间已入住的数量
		int checkInCount = checkDao.findCheckInCountByTypeName(bean);
		int balance = total - reserveCount - checkInCount;
		return balance;
	}

	@Override
	public int nowRest(RoomTypeBean roomType) {
		int count = roomInfoDao.findAllRoomInfoCountByType(roomType.getId());
		return count;
	}
	
	@Override
	public RoomTypeBean getRoomType(int roomTypeId) {
		RoomTypeBean roomTypeBean = roomTypeDao.findRoomTypeById(roomTypeId);
		return roomTypeBean;
	}

	@Override
	public Map<String, Object> showPriceByTypeAndLevel(int typeId, String tel) {
		//所预订的房间类型信息
		RoomTypeBean roomTypeBean = roomTypeDao.findRoomTypeById(typeId);
		MenmbersBean member = memberDao.checkIdByMenmbers(tel);
		LevelDiscountBean level= levelDiscountDao.checkIdByLevelDiscount(member.getLb().getClassId());
		Map<String, Object> map = new HashMap<String, Object>();
		// 将会员折扣信息放入到map中
		map.put("level", level);
		map.put("roomTypeBean", roomTypeBean);
		return map;
	}
	
}
