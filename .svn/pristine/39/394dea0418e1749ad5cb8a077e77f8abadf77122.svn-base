package com.hotelsystem.service.user;

import java.util.List;
import java.util.Map;

import com.hotelsystem.bean.RoomTypeBean;
import com.hotelsystem.bean.ViewReserveRoomBean;

/**
 * @ClassNmae IClassService
 * @author ZhangJiaLin
 * @Descrption TODO
 * @Date 2018/8/4
 * @version 1.0
 */
public interface IRoomTypeService {
	
	// 得到的所有的房间类型
	public List<RoomTypeBean> getRoomType();
	
	// 得到该某一房间类型，非会员，会员的价位
	Map<String, Object> getPriceMap(int id);
	
	// 得到今日，某一类型房间还剩多少间房间
	public int nowRest(RoomTypeBean roomType);
	
	// 得到某一日期，某一类型房间还剩多少间房间
	public int availableRoomNumber(ViewReserveRoomBean bean);

	// 通过id得到RoomTypeBean
	public RoomTypeBean getRoomType(int roomTypeId);
	
	Map<String,Object> showPriceByTypeAndLevel(int typeId,String tel);
}
