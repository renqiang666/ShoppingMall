package com.hotelsystem.service.manager.suppermanager;

import org.apache.ibatis.annotations.Param;

import com.hotelsystem.bean.RoomInfoBean;

/**
 * 房间设置Service
 * @ClassName IOverTimeService
 * @Description XXX
 * @author Ren Qiang
 * @Date 2018/8/10 上午11:36
 * @version 1.0
 */
public interface IRoomInfoService {
	/**
	 * 添加房间
	 * @MethodName insertRoom
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/10 上午11:41
	 * @version 1.0
	 * @param bean 新的房间
	 * @return 返回添加结果
	 */
	String insertRoom(RoomInfoBean bean);
	/**
     * 根据房间ID删除该房间信息
     * @MethodName deleteRoomInfoById
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/10 上午11:45
	 * @version 1.0
	 * @param roomId 房间ID
     * @return 返回删除结果
     */
	String deleteRoomInfoById(int roomId);
	/**
     * 按房间号修改其房间状态
     * @MethodName updateRoomStateById
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/4 上午10:12
	 * @version 1.0
     * @param roomId 房间ID
     * @param aimStateId
     * @return 返回修改结果
     */
	String updateRoomStateById(int roomId,int aimStateId);
	/**
     * 根据房间ID查询该房间
     * @MethodName findRoomInfoById
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/10 上午11:45
	 * @version 1.0
	 * @param roomId 房间ID
     * @return 返回查找结果
     */
	String findRoomInfoById(int roomId);
	
}
