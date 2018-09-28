package com.hotelsystem.bean;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 预订房间信息
 * @ClassName: ReserveRoomBean 
 * @Description: TODO
 * @author jhz
 * @date 2018年8月4日 下午12:14:56 
 * @version v1.0
 */
public class ReserveRoomBean {
	/**
	 * 预订订单编号
	 */
	private String id;
	/**
	 * 支付宝流水号
	 */
	private String pay;
	/**
	 * 入住时间，
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkIn;
	/**
	 * 退房时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date checkOut;
	/**
	 * 抵达时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date arrive;
	/**
	 * 取消时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date cancel;
	/**
	 * 付款金额
	 */
	private double money;
	/**
	 * 订单状态
	 */
	private int state;
	/**
	 * 预订人编号
	 */
	private ReservePeopleBean reservePeople;
	/**
	 * 预订时填写的入住人信息列表
	 */
	private List<CheckInPersonBean> checkInPerson;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
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
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getArrive() {
		return arrive;
	}

	public void setArrive(Date arrive) {
		this.arrive = arrive;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
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

	public ReservePeopleBean getReservePeople() {
		return reservePeople;
	}

	public void setReservePeople(ReservePeopleBean reservePeople) {
		this.reservePeople = reservePeople;
	}

	public List<CheckInPersonBean> getCheckInPerson() {
		return checkInPerson;
	}

	public void setCheckInPerson(List<CheckInPersonBean> checkInPerson) {
		this.checkInPerson = checkInPerson;
	}

	@Override
	public String toString() {
		return "ReserveRoomBean [id=" + id + ", pay=" + pay + ", checkIn="
				+ checkIn + ", checkOut=" + checkOut + ", arrive=" + arrive
				+ ", cancel=" + cancel + ", money=" + money + ", state="
				+ state + ", reservePeople=" + reservePeople
				+ ", checkInPerson=" + checkInPerson + "]";
	}




}
