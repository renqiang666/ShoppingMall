package com.hotelsystem.service.user;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.CheckInPersonBean;
import com.hotelsystem.bean.ReserveNumberBean;
import com.hotelsystem.bean.ReservePeopleBean;
import com.hotelsystem.bean.ReserveRoomBean;
import com.hotelsystem.bean.RoomTypeBean;
import com.hotelsystem.bean.ViewReserveRoomBean;

public interface IReserveRoomService {
	// 添加预定
	String addRseerve(ReservePeopleBean reservePeopleBean, ReserveRoomBean reserveRoomBean,
		List<CheckInPersonBean> checkInPersonBeans,RoomTypeBean roomTypeBean);

	// 更新预定信息
	public boolean updateReserveInfo(CheckInPersonBean checkInPerson,
			ReserveRoomBean room, ReservePeopleBean people);

	// 展示预定信息
	public List<ViewReserveRoomBean> showReserveInfo(String id);

	PageInfo showPage(String id, int page);
	
}
