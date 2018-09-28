package com.hotelsystem.service.user.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
import com.hotelsystem.service.user.IReserveRoomService;
import com.hotelsystem.utils.CompareTime;
import com.hotelsystem.utils.OrderStatusEnum;

@Service
@Transactional
public class ReserveRoomServiceImpl implements IReserveRoomService {
	@Autowired
	private IReserveRoomDao reserveRoomDao;
	@Autowired
	private IReservePeopleDao reservePeopleDao;
	@Autowired
	private IReserveNumberDao reserveNumberDao;
	@Autowired
	private ICheckInPersonDao checkInPersonDao;
	@Autowired
	private IViewReserveRoomDao viewDao;
	@Autowired
	private Sid sid;
	@Autowired
	private IRoomTypeDao roomTypeDao;
	@Autowired
	private CompareTime compare;

	@Override
	public String addRseerve(ReservePeopleBean reservePeopleBean, ReserveRoomBean reserveRoomBean,
			List<CheckInPersonBean> checkInPersonBeans,RoomTypeBean roomTypeBean) {
		/**
		 * 0为"预定失败！" 1为"未登录，请先登录！" 2为"填写的预定信息不完整！" 3为"预定成功！"
		 */
		String res = "预订失败";

		// 数据判断验证
		if (reservePeopleBean.getTel() == null) {
			res = "当前未登录";
			return res;
		}
		
		// 获取入住时间
		Date checkInDate = reserveRoomBean.getCheckIn();
		
		// 获取退房时间
		Date checkOut = reserveRoomBean.getCheckOut();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
		String arrive=sdf.format(reserveRoomBean.getArrive());
		String cancel=sdf.format(reserveRoomBean.getCancel());
		String checkIn=sdf.format(checkInDate);
		if(checkInDate.after(checkOut) || !(checkInDate.after(new Date()))){
			res="请选择正确的入住及退房时间!";
			return res;
		};
		if(!compare.compareYear(cancel, checkIn) || !compare.compareYear(arrive, checkIn) 
				|| !compare.compareMonth(checkIn, arrive) || !compare.compareMonth(checkIn, cancel) 
				|| !compare.compareDay(checkIn, cancel) || !compare.compareDay(checkIn, arrive)){
			res="预抵时间以及取消时间应该同入住时间为同一天!";
			return res;
		}
		
		int count=0;
		for (CheckInPersonBean checkInPersonBean : checkInPersonBeans) {
			if(checkInPersonBean.getName()!=null){
				count++;
			}
		}
		if(count==0){
			res="请至少填写一个入住人信息";
			return res;
		}
		// 计算一天时间的毫秒数
		long nd = 1000 * 24 * 60 * 60;

		// 计算入住多少天
		int day = (int) ((checkOut.getTime() - checkInDate.getTime()) / nd);
		
		roomTypeBean = roomTypeDao.findRoomTypeById(roomTypeBean.getId());
		reserveRoomBean.setMoney(roomTypeBean.getPrice() * 1 * day);
		reserveRoomBean.setState(Integer.valueOf(OrderStatusEnum.WAIT_PAY.key));
		reserveRoomBean.setPay("0");

		// 查询预定人信息是否已存在
		ReservePeopleBean findBean = reservePeopleDao.findReservePeopleByPeopleTel(reservePeopleBean.getTel());

		if (findBean == null) {
			int peopleCount = reservePeopleDao.insertReservePeople(reservePeopleBean);
			if(peopleCount==0){
				res="预订失败";
			}else{
				res="预订成功";
			}
			// 设置房间预定的预订人信息
			reserveRoomBean.setReservePeople(reservePeopleBean);
			// 插入预定房间的信息
			int roomCount = reserveRoomDao.insertReserveRoom(reserveRoomBean);
			if(roomCount==0){
				res="预订失败";
			}else{
				res="预订成功";
			}
		} else {
			// 设置房间预定的预订人信息
			reserveRoomBean.setReservePeople(findBean);
			// 插入预定房间的信息
			int roomCount = reserveRoomDao.insertReserveRoom(reserveRoomBean);
			if(roomCount==0){
				res="预订失败";
			}else{
				res="预订成功";
			}
		}
		
		ReserveNumberBean reserveNumberBean = new ReserveNumberBean();
		reserveNumberBean.setCount(1);
		reserveNumberBean.setRoomType(roomTypeBean);
		reserveNumberBean.setReserveRoom(reserveRoomBean);
		// 插入预定房间数量信息
		int numberCount = reserveNumberDao.insertReserveNumber(reserveNumberBean);
		if(numberCount==0){
			res="预订失败";
		}else{
			res="预订成功";
		}
		// 循环插入入住人信息
		for (CheckInPersonBean checkInPersonBean : checkInPersonBeans) {
			checkInPersonBean.setReserveRoom(reserveRoomBean);
			int personCount = checkInPersonDao.insertCheckInPerson(checkInPersonBean);
			if(personCount==0){
				res="预订失败";
			}else{
				res="预订成功";
			}
		}
		return res;
	}

	@Override
	public boolean updateReserveInfo(CheckInPersonBean checkInPerson,
			ReserveRoomBean room, ReservePeopleBean people) {

		boolean flag = true;
		try {
			int roomCount = reserveRoomDao.updateReserveRoom(room);
			if(roomCount==0){
				flag=false;
			}
			int personCount = checkInPersonDao.updateCheckInPerson(checkInPerson);
			if(personCount==0){
				flag=false;
			}
			int peopleCount = reservePeopleDao.updateReservePeople(people);
			if(peopleCount==0){
				flag=false;
			}
		} catch (Exception e) {
			flag = false;

		}
		return flag;
	}

	@Override
	public List<ViewReserveRoomBean> showReserveInfo(String id) {
		List<ViewReserveRoomBean> views = viewDao.findById(id);
		return views;
	}

	@Override
	public PageInfo showPage(String id, int page) {
		PageHelper.startPage(page,2);
		List<ViewReserveRoomBean> views = viewDao.findByTel(id);
		PageInfo pages=new PageInfo(views);
		return pages;
	}

}
