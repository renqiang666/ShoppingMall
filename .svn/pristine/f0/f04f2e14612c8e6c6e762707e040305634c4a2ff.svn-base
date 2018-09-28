package com.hotelsystem.service.manager.checkin;

import java.util.List;

import com.hotelsystem.bean.GuestBean;

/**
 * @ClassName IGuestService
 * @Description TODO:
 * @Author Li Gen
 * @Date 2018年8月17日 下午2:44:16
 * @Version 1.0
 **/
public interface IGuestService {

	/**
	 * 添加宾客
	 */
	void addGuest(int roomId, GuestBean guest);

	/**
	 * 删除房间所有宾客
	 */
	void delGuest(Integer roomId);
	
	
	/**
	 * 按id查找
	 * @param id
	 * @return
	 */
	GuestBean findGuestById(String id);
	
	/**
	 * 按名字查找
	 * 名字可能重名所以list接收
	 * @param name
	 * @return
	 */
	List<GuestBean> findGuestByName(String name);
	
	/**
	 * 查询所有入住宾客
	 * @return
	 */
	List<GuestBean> findAll();
	/**
	 * 按房间号查询
	 */
	List<GuestBean> findGuestByRoomId(int id);

}
