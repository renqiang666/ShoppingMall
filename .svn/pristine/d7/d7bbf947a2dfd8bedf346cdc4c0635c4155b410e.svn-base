package com.hotelsystem.service.manager.checkin.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.hotelsystem.bean.CheckInBean;
import com.hotelsystem.bean.HotelDiscountBean;
import com.hotelsystem.bean.MenmbersBean;
import com.hotelsystem.bean.RoomInfoBean;
import com.hotelsystem.dao.ICheckInDao;
import com.hotelsystem.dao.IRoomInfoDao;
import com.hotelsystem.service.manager.checkin.ICheckInService;
import com.hotelsystem.utils.AesEncodeTUtil;
import com.hotelsystem.utils.DateCalculation;

/**
 * @ClassName CheckInServiceImpl
 * @Description TODO:
 * @Author Li Gen
 * @Date 2018年8月16日 上午8:52:40
 * @Version 1.0
 **/
@Service
@Transactional
public class CheckInServiceImpl implements ICheckInService {
	@Autowired
	private ICheckInDao dao;
	@Autowired
	private IRoomInfoDao rdao;
	@Autowired
	private Sid sid;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hotelsystem.service.manager.ICheckInService#findAll()
	 */
	@Override
	@Transactional
	public List<CheckInBean> findAll() {

		return dao.findAllCheckIn();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hotelsystem.service.manager.ICheckInService#findCheckInByRid(java
	 * .lang.Integer)
	 */
	@Override
	public List<CheckInBean> findCheckInByRid(Integer rid) {
		return dao.findCheckInByRid(rid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hotelsystem.service.manager.ICheckInService#addCheckIn(com.hotelsystem
	 * .bean.CheckInBean)
	 */
	@Override
	public void addCheckIn(CheckInBean bean) {
		
		 HashSet<Integer> roomIdList = dao.findAllRoomId();
		if (bean.getRoom() == null || bean.getPledgeMoney() <= 0
				|| bean.getPaidMoney() <= 0 || bean.getStayDays() <= 0) {
			TransactionAspectSupport.currentTransactionStatus()
					.setRollbackOnly();
		}
		if(!roomIdList.contains(bean.getRoom().getId())){
			TransactionAspectSupport.currentTransactionStatus()
			.setRollbackOnly();	
		}
		
		try {
			bean.setArriveTime(new Date());
			Date date = DateCalculation.getNewDate(new Date(),
					bean.getStayDays());
			String s = sid.next();
			bean.setLeaveTime(date);
			bean.setId(s);
			dao.insertCheckIn(bean);
			RoomInfoBean room = rdao.findRoomInfoById(bean.getRoom().getId());
			System.out.println(bean);
			if (room.getRoomState().getId() != 1) {
				TransactionAspectSupport.currentTransactionStatus()
						.setRollbackOnly();

			} else {
				rdao.updateRoomStateById(bean.getRoom().getId(), 3);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hotelsystem.service.manager.ICheckInService#extend(int, int,
	 * double)
	 */
	@Override
	public void extend(int roomId, int day, double payMoney) {
		if(day<=0 || payMoney<=0 ){
			TransactionAspectSupport.currentTransactionStatus()
			.setRollbackOnly();
		}
		List<CheckInBean> CheckInList = dao.findCheckInByRid(roomId);
		try {
			for (CheckInBean bean : CheckInList) {
				Date da = DateCalculation.getNewDate(bean.getLeaveTime(), day);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 12:00:00");
				dao.updateCheckIn(roomId, day, da, payMoney);
			}		
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 查询id入住信息
	 *
	 * @param id
	 */
	@Override
	public CheckInBean queryById(String id) {
		CheckInBean checkInBean = dao.findById(id);
		return checkInBean;
	}

	@Override
	public double judgeMoeny(int overTime, double money,
			CheckInBean checkInBean, HotelDiscountBean hotelDiscountBean) {

		if (overTime > 1) {
			money = money - checkInBean.getPaidMoney()
					+ checkInBean.getRoom().getRoomType().getPrice();
			if (hotelDiscountBean != null) {
				money = money * hotelDiscountBean.getValue();
			}
		} else {
			money = checkInBean.getRoom().getRoomType().getPrice();
		}

		money = money - checkInBean.getPledgeMoney();
		return money;
	}

	@Override
	public String judgePaidMoney(MenmbersBean menmbersBean, String money,
			double lev) {
		double memberCount = 1;

		if (menmbersBean != null) {
			if (isNumeric(money)) {
				memberCount = menmbersBean.getLb().getClassDiscount();
				money = String.valueOf((Double.parseDouble(money))
						* memberCount);
				// res= iMenmbersService.autoUpgrade(money, phone);
			}
		} else {
		}
		try {
			money = AesEncodeTUtil.encryptAES(String.valueOf(money));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return money;
	}

	@Override
	public String judgeRes(MenmbersBean menmbersBean) {
		if (menmbersBean != null) {
			return "";
		}
		return "输入的手机号没有会员优惠";
	}

	@Override
	public double findLev(MenmbersBean menmbersBean) {

		if (menmbersBean != null) {
			return menmbersBean.getLb().getClassDiscount();
		}
		return 1.0;
	}

	@Override
	public int deleteCheckIn(String ci_id) {
		int i = dao.deleteCheckIn(ci_id);
		return i;
	}

	public boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("^(\\-?)\\d+(\\.\\d+)?$");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.hotelsystem.service.manager.checkin.ICheckInService#colPrice(int, int)
	 */
	@Override
	public double colPrice(int roomId, int day) {
		double totalPrice=0;
		 HashSet<Integer> roomIdList = dao.findAllRoomId();
		if(roomIdList.contains(roomId)){
			RoomInfoBean room = rdao.findRoomInfoById(roomId);
			double price = room.getRoomType().getPrice();
			totalPrice = day*price;
		}else{
			totalPrice=0;
		}
		return totalPrice;
	}
}
