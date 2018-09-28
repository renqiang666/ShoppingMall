package com.hotelsystem.service.user;

import com.hotelsystem.bean.UserInfoBean;

/**
 * 修改用户信息及查询用户信息
 * @author lkt
 *
 */
public interface IChangeInfoService {
	/**
	 * 修改密码
	 * @param pass account
	 * @return String
	 */
	public String changePass(String pass,String account);
	//换绑手机号
	public String changeAccount(String account,int id);
	
	/**
	 * 更换邮箱信息
	 * @param mail account
	 * @return String
	 */
	public String changeMail(String mail,String account);
	
	/**
	 * 查看个人信息
	 * @param account
	 * @return UserInfoBean
	 */
	public UserInfoBean showInfo(String account);
}
