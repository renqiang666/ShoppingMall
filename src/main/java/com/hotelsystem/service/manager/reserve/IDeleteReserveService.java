package com.hotelsystem.service.manager.reserve;

import com.hotelsystem.bean.ReservePeopleBean;
import com.hotelsystem.bean.ReserveRoomBean;

public interface IDeleteReserveService {
	/**
	 * 
	 * @Title: deleteReservePeople 
	 * @Description: TODO
	 * @param @param bean
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	boolean deleteReservePeople(ReservePeopleBean bean);
	/**
	 * 
	 * @Title: deleteReserveRoom 
	 * @Description: TODO
	 * @param @param bean
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	boolean deleteReserveRoom(ReserveRoomBean bean);
	/**
	 * 
	 * @Title: deleteReserveNumber 
	 * @Description: TODO
	 * @param @param bean
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	String deleteReserveNumber(int id,String reserveRoomId);
	/**
	 * 
	 * @Title: deleteCheckInPerson 
	 * @Description: TODO
	 * @param @param bean
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	String deleteCheckInPerson(int id,String reserveRoomId);
	/**
	 * 
	 * @Title: deleteReserveService 
	 * @Description: TODO
	 * @param @param list
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	boolean deleteReserveService(String id,int reservePeopleId);
}
