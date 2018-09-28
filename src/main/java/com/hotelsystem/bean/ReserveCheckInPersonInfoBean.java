package com.hotelsystem.bean;
/**
 * 
* <p>Title: ReserveCheckInPersonInfoBean</p>
* <p>Description: 预定入住人信息实体类</p>
* @author linweichao
* @date 上午10:29:26
 */
public class ReserveCheckInPersonInfoBean {
	
	private int cpId;
	private String cpName;
	private ReserveRoomBean reserveRoom;

	public int getCpId() {
		return cpId;
	}

	public void setCpId(int cpId) {
		this.cpId = cpId;
	}

	public String getCpName() {
		return cpName;
	}

	public void setCpName(String cpName) {
		this.cpName = cpName;
	}

	public ReserveRoomBean getReserveRoom() {
		return reserveRoom;
	}

	public void setReserveRoom(ReserveRoomBean reserveRoom) {
		this.reserveRoom = reserveRoom;
	}
}
