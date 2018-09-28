package com.hotelsystem.bean;

/**
 * 
 * 用户信息表
 * 
 */
public class UserInfoBean {
	//主键
	private int id;
	//实名
	private String name;
	//身份证
	private String iden;
	//邮箱	
	private String email;
	//是否可以评论，默认否（0）
	private int comment;
	//登录表
	private UserLoginBean ulb;
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
	public String getIden() {
		return iden;
	}
	public void setIden(String iden) {
		this.iden = iden;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	
	public UserLoginBean getUlb() {
		return ulb;
	}
	public void setUlb(UserLoginBean ulb) {
		this.ulb = ulb;
	}
	@Override
	public String toString() {
		return "UserInfoBean [id=" + id + ", name=" + name + ", iden=" + iden + ", email=" + email
				+ ", comment=" + comment + "]";
	}
	
	
}
