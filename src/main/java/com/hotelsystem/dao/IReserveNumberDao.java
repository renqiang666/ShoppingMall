package com.hotelsystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hotelsystem.bean.ReserveNumberBean;

/**
 * 预定数量表
 * @ClassName: IReserveNumberDao 
 * @Description: TODO
 * @author jhz
 * @date 2018年8月4日 下午2:31:33 
 * @version v1.0
 */
@Repository
public interface IReserveNumberDao {
	/**
	 * 
	 * @Title: insertReserveNumber 
	 * @Description: TODO
	 * @param @param bean
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int insertReserveNumber(ReserveNumberBean bean);
	/**
	 * 
	 * @Title: updateReserveNumber 
	 * @Description: TODO
	 * @param @param bean
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int updateReserveNumber(ReserveNumberBean bean);
	/**
	 * 
	 * @Title: deleteReserveNumber 
	 * @Description: TODO
	 * @param @param id
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int deleteReserveNumber(int reserveNumberId);
	
	int deleteReserveNumberByRoomId(String roomId);
	/**
	 * 
	 * @Title: findReserveNumberByRoomId 
	 * @Description: TODO
	 * @param @param reserveRoomId
	 * @param @return
	 * @return List<ReserveNumberBean>
	 * @throws
	 */
	public List<ReserveNumberBean> findReserveNumberByRoomId(String reserveRoomId);
	
	/**
	 * 查询相应房间类型已预定数
	 */
	int hasOrderCount(int type);
	/**
	 * 
	 * @Title: findById 
	 * @Description: TODO
	 * @param @param id
	 * @param @return
	 * @return ReserveNumberBean
	 * @throws
	 */
	public ReserveNumberBean findById(int id);
	/**
	 * 通过订单号查找ReserveNumberBean
	 * @param reserveRoomId
	 * @return
	 */
	public ReserveNumberBean findReserveNumberById(String reserveRoomId);
}
