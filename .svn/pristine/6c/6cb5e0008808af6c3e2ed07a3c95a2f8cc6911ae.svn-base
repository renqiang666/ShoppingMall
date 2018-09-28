package com.hotelsystem.service.manager.reserve.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotelsystem.bean.CheckInPersonBean;
import com.hotelsystem.bean.ReserveNumberBean;
import com.hotelsystem.bean.ReservePeopleBean;
import com.hotelsystem.bean.ReserveRoomBean;
import com.hotelsystem.bean.RoomTypeBean;
import com.hotelsystem.bean.ViewReserveRoomBean;
import com.hotelsystem.dao.ICheckInDao;
import com.hotelsystem.dao.ICheckInPersonDao;
import com.hotelsystem.dao.IReserveNumberDao;
import com.hotelsystem.dao.IReservePeopleDao;
import com.hotelsystem.dao.IReserveRoomDao;
import com.hotelsystem.dao.IRoomInfoDao;
import com.hotelsystem.service.manager.reserve.IUpdateReserveService;
import com.hotelsystem.utils.CompareTime;

@Service
@Transactional
public class UpdateReserveServiceImpl implements IUpdateReserveService {

	@Autowired
	private IReserveNumberDao reserveNumberDao;
	@Autowired
	private IReservePeopleDao reservePeopleDao;
	@Autowired
	private IReserveRoomDao reserveRoomDao;
	@Autowired
	private ICheckInPersonDao checkInPersonDao;
	@Autowired
	private CompareTime compare;
	@Autowired
	private IRoomInfoDao roomInfoDao;
	@Autowired
	private ICheckInDao checkInDao;
	
	@Override
	public String updateReservePeople(ReservePeopleBean bean) {
		String res="更新失败";
		if(bean.getName()==null){
			res="预订人姓名不能为空";
			return res;
		}
		if(!bean.getTel().matches("^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$")){
			res="请输入正确的手机号!";
			return res;
		}
		int count = reservePeopleDao.updateReservePeople(bean);
		if (count != 0) {
			res="更新成功";
		} 
		return res;
	}

	@Override
	public String updateReserveRoom(ReserveRoomBean bean) {
		String res="更新失败";
		Date checkInDate=bean.getCheckIn();
		if(checkInDate.after(bean.getCheckOut()) || !(checkInDate.after(new Date()))){
			res="请选择正确的入住及退房时间!";
			return res;
		};
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
		String arrive=sdf.format(bean.getArrive());
		String cancel=sdf.format(bean.getCancel());
		String checkIn=sdf.format(checkInDate);
		if(!compare.compareYear(cancel, checkIn) || !compare.compareYear(arrive, checkIn) 
				|| !compare.compareMonth(checkIn, arrive) || !compare.compareMonth(checkIn, cancel) 
				|| !compare.compareDay(checkIn, cancel) || !compare.compareDay(checkIn, arrive)){
			res="请选择正确的预抵时间以及取消时间!";
			return res;
		}
		int count = reserveRoomDao.updateReserveRoom(bean);
		if (count != 0) {
			res="更新成功";
		} 
			return res;
	}

	@Override
	public String updateReserveNumber(@RequestBody List<Map<String, Object>> list) {
		String res="更新失败";
		ObjectMapper mapper = new ObjectMapper();
		RoomTypeBean roomTypeBean = mapper.convertValue(
				list.get(1).get("roomTypeBean"),
				RoomTypeBean.class);
		int id=roomTypeBean.getId();
		if(id==0){
			return "请选择正确的房间类型";
		}
		ReserveNumberBean reserveNumberBean = mapper.convertValue(
				list.get(0).get("reserveNumberBean"),
				ReserveNumberBean.class);
		ReserveRoomBean reserveRoomBean = mapper.convertValue(list.get(2).get("reserveRoomBean"),
				ReserveRoomBean.class);
		ViewReserveRoomBean bean = reserveRoomDao.findViewReserveRoomByRoomId(reserveRoomBean.getId());
		int roomCount = roomInfoDao.findSpecialRoomInfoCountByType(id);
		int reserveCount=reserveRoomDao.findReserveCountByTypeName(bean);
		int checkInCount = checkInDao.findCheckInCountByTypeName(bean);
		int balance = roomCount-reserveCount-checkInCount;
		if(reserveNumberBean.getCount()<= 0 || reserveNumberBean.getCount()>balance){
			return "选定时间段内该类型房间数量不足";
		}
		reserveNumberBean.setRoomType(roomTypeBean);
		int count = reserveNumberDao.updateReserveNumber(reserveNumberBean);
		if (count != 0) {
			res="更新成功";
		} 
			return res;
	}

	@Override
	public String updateCheckInPerson(CheckInPersonBean bean) {
		String res="更新失败";
		if(bean.getName()==null){
			return "请输入入住人姓名";
		}
		int count = checkInPersonDao.updateCheckInPerson(bean);
		if (count != 0) {
			res="更新成功";
		} 
			return res;
	}
}
