package com.hotelsystem.service.manager.checkin.impl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.hotelsystem.bean.GuestBean;
import com.hotelsystem.bean.RoomInfoBean;
import com.hotelsystem.dao.IGuestDao;
import com.hotelsystem.dao.IRoomInfoDao;
import com.hotelsystem.service.manager.checkin.IGuestService;

/**
 * @ClassName GuestServiceImpl
 * @Description TODO:
 * @Author Li Gen
 * @Date 2018年8月17日 下午2:46:55
 * @Version 1.0
 **/
@Service
@Transactional
public class GuestServiceImpl implements IGuestService {

	@Autowired
	private IGuestDao gdao;
	@Autowired
	private IRoomInfoDao rdao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hotelsystem.service.manager.IGuestService#addGuest(int,
	 * com.hotelsystem.bean.GuestBean)
	 */
	@Override
	public void addGuest(int roomId, GuestBean guest) {
		HashSet<String> set = gdao.findAllGuestId();
		if (!set.contains(guest.getId())) {
			RoomInfoBean room = rdao.findRoomInfoById(roomId);
			guest.setRoom(room);
			gdao.insertGuest(guest);
		}else{
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); 
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hotelsystem.service.manager.IGuestService#delGuest(int)
	 */
	@Override
	public void delGuest(Integer roomId) {
		gdao.deleteGuest(roomId);
	}

	@Override
	public GuestBean findGuestById(String id) {
		GuestBean guestBean = gdao.findGuestById(id);
		return guestBean;
	}

	@Override
	public List<GuestBean> findGuestByName(String name) {
		return gdao.findGuestByName(name);
	}

	@Override
	public List<GuestBean> findAll() {
		return gdao.findAllGuestBean();
	}

	@Override
	public List<GuestBean> findGuestByRoomId(int id) {
		return gdao.findGuestByRoomId(id);
	}

}
