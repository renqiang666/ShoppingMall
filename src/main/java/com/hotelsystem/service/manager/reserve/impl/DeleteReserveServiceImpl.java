package com.hotelsystem.service.manager.reserve.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotelsystem.bean.CheckInPersonBean;
import com.hotelsystem.bean.ReserveNumberBean;
import com.hotelsystem.bean.ReservePeopleBean;
import com.hotelsystem.bean.ReserveRoomBean;
import com.hotelsystem.dao.ICheckInPersonDao;
import com.hotelsystem.dao.IReserveNumberDao;
import com.hotelsystem.dao.IReservePeopleDao;
import com.hotelsystem.dao.IReserveRoomDao;
import com.hotelsystem.service.manager.reserve.IDeleteReserveService;

@Service
@Transactional
public class DeleteReserveServiceImpl implements IDeleteReserveService {
	@Autowired
	private IReserveNumberDao reserveNumberDao;
	@Autowired
	private IReservePeopleDao reservePeopleDao;
	@Autowired
	private IReserveRoomDao   reserveRoomDao;
	@Autowired
	private ICheckInPersonDao checkInPersonDao;
	
	@Override
	public boolean deleteReservePeople(ReservePeopleBean bean) {
		int count = reservePeopleDao.deleteReservePeople(bean);
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean deleteReserveRoom(ReserveRoomBean bean) {
		int count = reserveRoomDao.deleteReserveRoom(bean);
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String deleteReserveNumber(int id,String reserveRoomId) {
		List<ReserveNumberBean> list = reserveNumberDao.findReserveNumberByRoomId(reserveRoomId);
		if(list.size()==1){
			return "最后一种类型的房间，只可以修改";
		}
		int count = reserveNumberDao.deleteReserveNumber(id);
		if (count == 0) {
			return "删除失败";
		} else {
			return "删除成功";
		}
	}

	@Override
	public String deleteCheckInPerson(int id,String reserveRoomId) {
		List<CheckInPersonBean> list = checkInPersonDao.findCheckInPersonByRoomId(reserveRoomId);
		if(list.size()==1){
			return "至少存在以为入住人，当前只能修改";
		}
		int count = checkInPersonDao.deleteCheckInPerson(id);
		if (count == 0) {
			return "删除失败";
		} else {
			return "删除成功";
		}
	}
	
	@Override
	public boolean deleteReserveService(String id,int reservePeopleId) {
		boolean res = true;
		// 删除预订人信息
		ReservePeopleBean reservePeopleBean = reservePeopleDao.findReservePeopleByPeopleId(reservePeopleId);
		int reservePeopleCount = reservePeopleDao.deleteReservePeople(reservePeopleBean);
		if (reservePeopleCount == 0) {
			res = false;
		}
		
		// 删除房间预订信息
		ReserveRoomBean reserveRoomBean = reserveRoomDao.findReserveRoomByRoomId(id);
		int reserveRoomCount = reserveRoomDao.deleteReserveRoom(reserveRoomBean);
		if (reserveRoomCount == 0) {
			res = false;
		}
		//删除入住人信息
		List<CheckInPersonBean> checkInPersonList = checkInPersonDao.findCheckInPersonByRoomId(id);
		for (CheckInPersonBean bean : checkInPersonList) {
			int checkInPersonCount = checkInPersonDao.deleteCheckInPerson(bean.getId());
			if (checkInPersonCount == 0) {
				res = false;
			}
		}
		//删除预订房间类型数量信息
		 List<ReserveNumberBean>  reserveNumberList = reserveNumberDao.findReserveNumberByRoomId(id);
		 for (ReserveNumberBean bean : reserveNumberList) {
			 	int reserveNumberCount = reserveNumberDao.deleteReserveNumber(bean.getId());
			 	if (reserveNumberCount == 0) {
			 		res = false;
			 	}
		 }
		 return res;
	}

}
