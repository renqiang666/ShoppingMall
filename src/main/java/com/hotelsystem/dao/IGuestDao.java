package com.hotelsystem.dao;

import java.util.HashSet;
import java.util.List;

import com.hotelsystem.bean.GuestBean;

/**
 *@ClassName ICounterDao
 *@Description TODO:
 *@Author Li Gen
 *@Date 2018年8月5日 下午10:59:01
 *@Version 1.0
 **/
public interface IGuestDao {
	/**
	 * 添加宾客
	 */	
	public void insertGuest(GuestBean guest);
	/**
	 * 删除宾客
	 */	
	public void deleteGuest(Integer rid);
			
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
	List<GuestBean> findGuestByName(String guestName);
	/**
	 * 查询所有
	 * @return
	 */
	List<GuestBean> findAllGuestBean();
	/**
	 * 按房间名查找
	 * @param 房间号
	 * @return
	 */
	List<GuestBean> findGuestByRoomId(Integer id);
	/**
	 * 
	 * @Title: findAllGuestId 
	 * @Description: TODO
	 * @param @return
	 * @return HashSet<String>
	 * @throws
	 */
	public HashSet<String> findAllGuestId();

}
