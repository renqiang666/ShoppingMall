package com.hotelsystem.bean;

/**
 * @ClassName: ReserveNumberBean 
 * @Description: TODO
 * @author jhz
 * @date 2018年8月4日 下午12:08:01 
 * @version v1.0
 */
public class ReserveNumberBean {
	/**
	 * 主键ID
	 */
	private int id;
	/**
	 * 预订房间数量
	 */
	private int count;
	/**
	 * 预订房间类型编号
	 */
	private RoomTypeBean roomType;
	/**
	 * 预订订单编号
	 */
	private ReserveRoomBean reserveRoom;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public RoomTypeBean getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomTypeBean roomType) {
		this.roomType = roomType;
	}

	public ReserveRoomBean getReserveRoom() {
		return reserveRoom;
	}

	public void setReserveRoom(ReserveRoomBean reserveRoom) {
		this.reserveRoom = reserveRoom;
	}

	@Override
	public String toString() {
		return "ReserveNumberBean [id=" + id + ", count=" + count
				+ ", roomType=" + roomType + ", reserveRoom=" + reserveRoom
				+ "]";
	}





}
