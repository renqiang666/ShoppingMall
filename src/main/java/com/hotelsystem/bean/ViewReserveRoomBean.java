package com.hotelsystem.bean;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 房间预定信息视图
 * @ClassName: ViewReserveRoomBean 
 * @Description: TODO
 * @author lwc
 * @date 2018年8月17日 上午10:44:35 
 * @version v1.0
 */
public class ViewReserveRoomBean {
	/**
	 * 房间预定id
	 */
	private String id;
	/**
	 * 入住时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkIn;
	/**
	 * 退房时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkOut;
	/**
	 * 预计到达时间
	 */
	private Date arrive;
	/**
	 * 订单取消时间
	 */
	
	private Date cancel;
	/**
	 * 已支付金额
	 */
	private double money;
	/**
	 * 订单状态
	 */
	private int state;
	/**
	 * 预订人编号
	 */
	private int reservePeopleId;
	/**
	 * 预订人姓名
	 */
	private String reservePeopleName;
	/**
	 * 联系方式
	 */
	private String tel;
	/**
	 * 客户留言
	 */
	private String context;
	/**
	 * 房间类型数量表主键
	 */
	private int reserveNumberId;
	/**	
	 * 预定房间数量
	 */
	private int roomCount;
	/**
	 * 房间类型ID
	 */
	private int roomTypeId;
	/**
	 * 预定房间类型
	 */
	private String roomType;
	/**
	 * 房间单价
	 */
	private double price;
	/**
	 * 入住人编号
	 */
	private int checkInPersonId;
	/**
	 * 入住人姓名
	 */
	private String checkInPeople;
	/**
	 * 入住人
	 */
	private List<String> checkInPeoples;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@JsonFormat(pattern="yyyy-MM-dd")
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	@JsonFormat(pattern="yyyy-MM-dd")
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
	public Date getArrive() {
		return arrive;
	}
	public void setArrive(Date arrive) {
		this.arrive = arrive;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
	public Date getCancel() {
		return cancel;
	}
	public void setCancel(Date cancel) {
		this.cancel = cancel;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getReservePeopleId() {
		return reservePeopleId;
	}
	public void setReservePeopleId(int reservePeopleId) {
		this.reservePeopleId = reservePeopleId;
	}
	public String getReservePeopleName() {
		return reservePeopleName;
	}
	public void setReservePeopleName(String reservePeopleName) {
		this.reservePeopleName = reservePeopleName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getReserveNumberId() {
		return reserveNumberId;
	}
	public void setReserveNumberId(int reserveNumberId) {
		this.reserveNumberId = reserveNumberId;
	}
	public int getRoomCount() {
		return roomCount;
	}
	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}
	public int getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCheckInPersonId() {
		return checkInPersonId;
	}
	public void setCheckInPersonId(int checkInPersonId) {
		this.checkInPersonId = checkInPersonId;
	}
	public String getCheckInPeople() {
		return checkInPeople;
	}
	public void setCheckInPeople(String checkInPeople) {
		this.checkInPeople = checkInPeople;
	}
	
	public List<String> getCheckInPeoples() {
		return checkInPeoples;
	}
	public void setCheckInPeoples(List<String> checkInPeoples) {
		this.checkInPeoples = checkInPeoples;
	}
	@Override
	public String toString() {
		return "ViewReserveRoomBean [id=" + id + ", checkIn=" + checkIn
				+ ", checkOut=" + checkOut + ", arrive=" + arrive + ", cancel="
				+ cancel + ", money=" + money + ", state=" + state
				+ ", reservePeopleId=" + reservePeopleId
				+ ", reservePeopleName=" + reservePeopleName + ", context="
				+ context + ", reserveNumberId=" + reserveNumberId
				+ ", roomCount=" + roomCount + ", roomTypeId=" + roomTypeId
				+ ", roomType=" + roomType + ", price=" + price
				+ ", checkInPersonId=" + checkInPersonId + ", checkInPeople="
				+ checkInPeople + "]";
	}
	
	
	
}
