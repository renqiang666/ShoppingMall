package com.hotelsystem.service.manager.reserve.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.CheckInPersonBean;
import com.hotelsystem.bean.ReserveNumberBean;
import com.hotelsystem.bean.ReservePeopleBean;
import com.hotelsystem.bean.ReserveRoomBean;
import com.hotelsystem.bean.RoomTypeBean;
import com.hotelsystem.bean.ViewReserveRoomBean;
import com.hotelsystem.dao.ICheckInPersonDao;
import com.hotelsystem.dao.IReserveNumberDao;
import com.hotelsystem.dao.IReservePeopleDao;
import com.hotelsystem.dao.IReserveRoomDao;
import com.hotelsystem.dao.IRoomTypeDao;
import com.hotelsystem.dao.IViewReserveRoomDao;
import com.hotelsystem.service.manager.reserve.IFindReserveService;

@Service
@Transactional
public class FindReserveServiceImpl implements IFindReserveService {
	@Autowired
	private IViewReserveRoomDao dao;
	@Autowired
	private IReserveNumberDao reserveNumberDao;
	@Autowired
	private IReservePeopleDao reservePeopleDao;
	@Autowired
	private IReserveRoomDao   reserveRoomDao;
	@Autowired
	private ICheckInPersonDao checkInPersonDao;
	@Autowired
	private IRoomTypeDao roomTypeDao;
	
	@Override
	public PageInfo findReserveRoomByName(int current,String name) {
		PageHelper.startPage(current , 10);
		String currentName="%"+name+"%";
		List<ViewReserveRoomBean> list = dao.findByName(currentName);
		PageInfo page = new PageInfo(list);
		return page;
	}
	@Override
	public PageInfo findReserveRoomById(int current,String id) {
		PageHelper.startPage(current , 10);
		List<ViewReserveRoomBean> list = dao.findById(id);
		PageInfo page = new PageInfo(list);
		return page;
	}
	@Override
	public PageInfo findAll(int current) {
		PageHelper.startPage(current , 10);
		List<ViewReserveRoomBean> list = dao.findAllReserveMessage();
		PageInfo page = new PageInfo(list);
		return page;
	}
	@Override
	public Map<String, Object> findMsgByRoomIdAndPeopleId(String id,int reservePeopleId) {
		Map<String, Object> map = new HashMap<String, Object>();
		//预订人信息
		ReservePeopleBean reservePeopleBean = reservePeopleDao.findReservePeopleByPeopleId(reservePeopleId);
		map.put("reservePeopleBean", reservePeopleBean);
		// 房间预订信息
		ReserveRoomBean reserveRoomBean = reserveRoomDao.findReserveRoomByRoomId(id);
		map.put("reserveRoomBean", reserveRoomBean);
		//入住人信息
		List<CheckInPersonBean> checkInPersonList = checkInPersonDao.findCheckInPersonByRoomId(id);
		map.put("checkInPersonList", checkInPersonList);
		//预订房间类型数量信息
		 List<ReserveNumberBean>  reserveNumberList = reserveNumberDao.findReserveNumberByRoomId(id);
		map.put("reserveNumberList", reserveNumberList);
		
		List<RoomTypeBean> roomTypeList=roomTypeDao.findRoomType();
		map.put("roomTypeList", roomTypeList);
		return map;
	}
	@Override
	public CheckInPersonBean findPersonById(int id) {
		return checkInPersonDao.findById(id);
	}
	@Override
	public ReserveNumberBean findNumberById(int id) {
		return reserveNumberDao.findById(id);
	}
	

}
