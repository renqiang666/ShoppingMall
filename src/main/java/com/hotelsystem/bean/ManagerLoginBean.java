package com.hotelsystem.bean;

import java.util.List;

/**
 * @ClassNmae ManagerLoginBean
 * @author Weizhengyi
 * @Descrption TODO
 * @Date 2018/8/4
 * @version 1.0
 */
public class ManagerLoginBean {

	private int userId;
	private String userName;
	private String userPwd;
	private int userIdentity;
	private List<ManagerRecordBean> listMr;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public int getUserIdentity() {
		return userIdentity;
	}

	public void setUserIdentity(int userIdentity) {
		this.userIdentity = userIdentity;
	}

	public List<ManagerRecordBean> getListMr() {
		return listMr;
	}

	public void setListMr(List<ManagerRecordBean> listMr) {
		this.listMr = listMr;
	}

	@Override
	public String toString() {
		return "ManagerLoginBean [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd
				+ ", userIdentity=" + userIdentity + ", listMr=" + listMr + "]";
	}
	
}
