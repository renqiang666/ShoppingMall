package com.hotelsystem.bean;

/**
 * 
 * @ClassName GuestBean
 * @Description TODO:宾客实体
 * @Author Li Gen
 * @Date 2018年8月4日 上午9:47:24
 * @Version 1.0
 *
 */
public class GuestBean {
	// 身份证号码
	private String id;
	// 姓名
	private String name;
	// 性别
	private String sex;
	// 联系方式
	private String tele;
	//房间
	private RoomInfoBean room;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public RoomInfoBean getRoom() {
		return room;
	}
	public void setRoom(RoomInfoBean room) {
		this.room = room;
	}
	@Override
	public String toString() {
		return "GuestBean [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", tele=" + tele + ", room=" + room + "]";
	}
	
}
