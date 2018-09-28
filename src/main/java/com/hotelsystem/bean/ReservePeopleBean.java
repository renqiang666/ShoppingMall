package com.hotelsystem.bean;

import java.util.List;

/**
 * 
 * @ClassName: ReservePeopleBean 
 * @Description: TODO
 * @author jhz
 * @date 2018年8月4日 下午12:13:56 
 * @version v1.0
 */
public class ReservePeopleBean {
	/**
	 * 预订人编号
	 */
	private int id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 手机号码
	 */
	private String tel;
	/**
	 * 客户留言
	 */
	private String message;
	/**
	 * 已经预订的订单列表
	 */
	private List<ReserveRoomBean> reserveRoomList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ReserveRoomBean> getReserveRoomList() {
		return reserveRoomList;
	}

	public void setReserveRoomList(List<ReserveRoomBean> reserveRoomList) {
		this.reserveRoomList = reserveRoomList;
	}

	@Override
	public String toString() {
		return "ReservePeopleBean [id=" + id + ", name=" + name + ", tel="
				+ tel + ", message=" + message + "]";
	}
	
	
}
