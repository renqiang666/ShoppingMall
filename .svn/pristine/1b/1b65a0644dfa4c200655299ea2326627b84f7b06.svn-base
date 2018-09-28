package com.hotelsystem.service.manager.reserve;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.CheckInPersonBean;
import com.hotelsystem.bean.ReserveNumberBean;
import com.hotelsystem.bean.ViewReserveRoomBean;


public interface IFindReserveService {
	/**
	 * 模糊查找,通过预订人姓名
	 * @Title: findReserveRoom 
	 * @Description: TODO
	 * @param @param name
	 * @param @return
	 * @return List<ReserveRoomBean>
	 * @throws
	 */
	PageInfo findReserveRoomByName(int current,String name);
	/**
	 * 通过订单编号
	 * @Title: findReserveRoomById 
	 * @Description: TODO
	 * @param @param id
	 * @param @return
	 * @return List<ReserveRoomBean>
	 * @throws
	 */
	PageInfo findReserveRoomById(int current,String id);
	/**
	 * 
	 * @Title: findAll 
	 * @Description: TODO
	 * @param @return
	 * @return List<ViewReserveRoomBean>
	 * @throws
	 */
	PageInfo findAll(int current);
	/**
	 * 
	 * @Title: findMsgByRoomIdAndPeopleId 
	 * @Description: TODO
	 * @param @param id
	 * @param @param reservePeopleId
	 * @param @return
	 * @return Map<String,Object>
	 * @throws
	 */
	Map<String, Object> findMsgByRoomIdAndPeopleId(String id,int reservePeopleId);
	/**
	 * 
	 * @Title: findPersonById 
	 * @Description: TODO
	 * @param @param id
	 * @param @return
	 * @return CheckInPersonBean
	 * @throws
	 */
	CheckInPersonBean findPersonById(int id);
	/**
	 * 
	 * @Title: findNumberById 
	 * @Description: TODO
	 * @param @param id
	 * @return void
	 * @throws
	 */
	ReserveNumberBean findNumberById(int id);
}
