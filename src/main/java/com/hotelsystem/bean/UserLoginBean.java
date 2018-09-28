package com.hotelsystem.bean;



/**
 * 
 * 登陆表
 * @author 张加林
 */
public class UserLoginBean {
	/**登陆表的id*/
	private int id;
	/**账号和手机号*/
	private String account;
	/**密码*/
	private String pass;	
	//用户信息外键(一对一)
	private UserInfoBean uib;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public UserInfoBean getUib() {
		return uib;
	}
	public void setUib(UserInfoBean uib) {
		this.uib = uib;
	}
	@Override
	public String toString() {
		return "UserLoginBean [id=" + id + ", account=" + account + ", pass=" + pass + "]";
	}
}
