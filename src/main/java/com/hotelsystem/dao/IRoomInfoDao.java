package com.hotelsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hotelsystem.bean.RoomInfoBean;

/**
 * 房间信息表Dao
 * @ClassName IRoomInfoDao
 * @Description XXX
 * @author Ren Qiang
 * @Date 2018/8/4 上午10:11
 * @version 1.0
 */
public interface IRoomInfoDao {
	 /**
     * 按房间号修改其房间状态
     * @MethodName updateRoomStateById
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/4 上午10:12
	 * @version 1.0
     * @param roomId 房间ID
     * @param aimStateId
     * @return 返回受影响行数
     */
	public int updateRoomStateById(@Param("roomId")int roomId,@Param("aimStateId")int aimStateId);
	/**
     * 按房间号查询房间状态
     * @MethodName findRoomInfoById
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/6 上午10:37
	 * @version 1.0
     * @param roomId 房间ID
     * @return 返回房间信息Bean
     */
	public RoomInfoBean findRoomInfoById(int roomId);
	/**
     * 查询所有房间信息
     * @MethodName findRoomInfoById
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/6 上午11:05
	 * @version 1.0
     * @return 返回所有房间信息的List
     */
	public List<RoomInfoBean> findAllRoomInfo();
	/**
     * 根据房间类型查询此类型可用预定数量
     * @MethodName findRoomInfoById
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/6 上午11:35
	 * @version 1.0
     * @return 返回此类型房间可用数量
     */
	public int findAllRoomInfoCountByType(int typeId);
	/**
     * 根据房间类型查询此类型可用预定数量
     * @MethodName findSpecialRoomInfoCountByType
	 * @Description TODO
	 * @author Zhang JiaLin
	 * @Date 2018/8/7 
	 * @version 1.0
     * @return 返回此类型房间所有数量，不管有没有被预定或者入住数量
     */
	public int findSpecialRoomInfoCountByType(int typeID);
	/**
     * 根据房间ID删除该房间信息
     * @MethodName deleteRoomInfoById
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/6 上午14:35
	 * @version 1.0
	 * @param roomId 房间ID
     * @return 返回此类型房间可用数量
     */
	public int deleteRoomInfoById(int roomId);
	/**
     * 添加房间
     * @MethodName insertRoom
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/6 上午14:49
	 * @version 1.0
	 * @param bean 新房间
     * @return 返回受影响行数
     */
	public int insertRoom(RoomInfoBean bean);
	
	/**
	 * 通过类型查询空闲房间
	 * @return
	 */
	List<RoomInfoBean> findEmptyRoomByType(int typeId);
	/**
	 * 查询相应类型的房间信息
	 */
	List<RoomInfoBean> findRoomByType(int type);
	/**
	 * 展示房间信息
	 */
	List<RoomInfoBean> roomDisplayAll();
	
}
