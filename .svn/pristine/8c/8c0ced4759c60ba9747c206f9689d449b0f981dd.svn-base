package com.hotelsystem.service.manager.reserve.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.hotelsystem.dao.IRoomTypeDao;
import com.hotelsystem.service.manager.reserve.IAddReserveSerrvice;
import com.hotelsystem.utils.CompareTime;

@Service
public class AddReserveServiceImpl implements IAddReserveSerrvice {
	@Autowired
	private Sid sid;
	@Autowired
	private IReserveNumberDao reserveNumberDao;
	@Autowired
	private IReservePeopleDao reservePeopleDao;
	@Autowired
	private IReserveRoomDao   reserveRoomDao;
	@Autowired
	private ICheckInPersonDao checkInPersonDao;
	@Autowired
	private IRoomInfoDao roomInfoDao;
	@Autowired
	private IRoomTypeDao roomTypeDao;
	@Autowired
	private ICheckInDao checkInDao;
	@Autowired
	private CompareTime compare;

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public Map<String, Object> addReserveService(List<Map<String, Object>> list) {
		String res="添加失败!";
		/*
		 * 转换Bean，同时验证数据
		 */
		Map<String, Object> map= new HashMap<String, Object>();
		
		int size=(int) list.get(list.size()-1).get("i");
		ObjectMapper mapper=new ObjectMapper();
		/*DeserializationConfig cfg= mapper.getDeserializationConfig();
		cfg.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		mapper.setDeserializationConfig(cfg);
		cfg.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		mapper.setDeserializationConfig(cfg);*/

		//转换预订人信息
		ReservePeopleBean reservePeopleBean=mapper.convertValue(list.get(2*size).get("reservePeopleBean"),ReservePeopleBean.class);
		//转换房间预订信息
		ReserveRoomBean reserveRoomBean = mapper.convertValue( list.get(2*size+2).get("reserveRoomBean"),ReserveRoomBean.class);
		//转换入住人信息
				CheckInPersonBean checkInPersonBean = mapper.convertValue( list.get(2*size+1).get("checkInPersonBean"),CheckInPersonBean.class);
		if(reservePeopleBean==null){
			res="预订人不能为空";
			map.put("res", res);
			return map;
		}
		if(reservePeopleBean.getName()==null){
			res="预订人姓名不能为空";
			map.put("res", res);
			return map;
		}
		if(reservePeopleBean.getTel()==null){
			res="预订人手机号不能为空";
			map.put("res", res);
			return map;
		}
		if(!reservePeopleBean.getTel().matches("^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$")){
			res="请输入正确的手机号!";
			map.put("res", res);
			return map;
		}
		if(reserveRoomBean==null || reserveRoomBean.getArrive()==null
				|| reserveRoomBean.getCancel()==null|| reserveRoomBean.getCheckIn()==null
				|| reserveRoomBean.getCheckOut()==null){
			res="预订时间不能为空";
			map.put("res", res);
			return map;
		}
		Date checkInDate=reserveRoomBean.getCheckIn();
		
		if(checkInDate.after(reserveRoomBean.getCheckOut()) || !(checkInDate.after(new Date()))){
			res="入住时间要在当前时间之后，退房时间要在入住时间之后!";
			map.put("res", res);
			return map;
		};
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
		String arrive=sdf.format(reserveRoomBean.getArrive());
		String cancel=sdf.format(reserveRoomBean.getCancel());
		String checkIn=sdf.format(checkInDate);
		if(!compare.compareYear(cancel, checkIn) || !compare.compareYear(arrive, checkIn) 
				|| !compare.compareMonth(checkIn, arrive) || !compare.compareMonth(checkIn, cancel) 
				|| !compare.compareDay(checkIn, cancel) || !compare.compareDay(checkIn, arrive)){
			res="预抵时间与取消时间应该同入住时间为同一天!"; 
			map.put("res", res);
			return map;
		}
		ViewReserveRoomBean viewBean = new ViewReserveRoomBean();
		viewBean.setCheckIn(checkInDate);
		viewBean.setCheckOut(reserveRoomBean.getCheckOut());
		if(checkInPersonBean==null || checkInPersonBean.getName()==null){
			res="请至少填写一个入住人姓名";
			map.put("res", res);
			return map;
		}
		List rList = new ArrayList();
		for(int i=size;i<2*size;i++){
			RoomTypeBean roomTypeBean=mapper.convertValue(list.get(i-size).get("roomTypeBean"), RoomTypeBean.class);
			int id = roomTypeBean.getId();
			viewBean.setRoomTypeId(id);
			int roomCount = roomInfoDao.findSpecialRoomInfoCountByType(id);
			int reserveCount=reserveRoomDao.findReserveCountByTypeName(viewBean);
			int checkInCount = checkInDao.findCheckInCountByTypeName(viewBean);
			int balance = roomCount-reserveCount-checkInCount;
			ReserveNumberBean reserveNumberBean=mapper.convertValue(list.get(i).get("reserveNumberBean"),ReserveNumberBean.class);
			if(reserveNumberBean.getCount()<= 0 || reserveNumberBean.getCount()>balance){
				res="该类型房间数量不足!"; 
				map.put("res", res);
				return map;
			}else{
				rList.add(roomTypeBean);
				rList.add(reserveNumberBean);
			}
		}
		//插入预订人信息
		ReservePeopleBean rBean = reservePeopleDao.findReservePeopleByPeopleTel(reservePeopleBean.getTel());
		if(rBean==null){
			int reservePeopleCount = reservePeopleDao.insertReservePeople(reservePeopleBean);
			if(reservePeopleCount!=0){
				res="添加成功!";
			}else{
				res="添加失败!";
			}
			reserveRoomBean.setReservePeople(reservePeopleBean);
		}else if(rBean.getName()!=reservePeopleBean.getName()){
			res="已存在该手机号，但是预订人姓名不同";
			
		}else{
			reserveRoomBean.setReservePeople(rBean);
		}
		
		
		String roomId=sid.next();
		reserveRoomBean.setId(roomId);
		reserveRoomBean.setMoney(0);
		
		
		//插入预订房间信息
		int reserveRoomCount = reserveRoomDao.insertReserveRoom(reserveRoomBean);
		if(reserveRoomCount!=0){
			res="添加成功!";
		}else{
			res="添加失败!";
		}
		
		checkInPersonBean.setReserveRoom(reserveRoomBean);
		//插入入住人信息
		int checkInPersonCount = checkInPersonDao.insertCheckInPerson(checkInPersonBean);
		if(checkInPersonCount!=0){
			res="添加成功!";
		}else{
			res="添加失败!";
		}
	
		for(int i=0;i<rList.size();i+=2){
			RoomTypeBean roomTypeBean=(RoomTypeBean) rList.get(i);
			ReserveNumberBean reserveNumberBean=(ReserveNumberBean) rList.get(i+1);
			reserveNumberBean.setReserveRoom(reserveRoomBean);
			reserveNumberBean.setRoomType(roomTypeBean);
			//插入房间类型信息
			int reserveNumberCount = reserveNumberDao.insertReserveNumber(reserveNumberBean);
			if(reserveNumberCount!=0){
				res="添加成功!";
			}else{
				res="添加失败!";
			}
		}
		map.put("res", res);
		map.put("tel", reservePeopleBean.getTel());
		map.put("roomId", roomId);
		return map;
	}
	
}
