package com.hotelsystem.dao;

import org.apache.ibatis.annotations.Param;

import com.hotelsystem.bean.UserInfoBean;
import com.hotelsystem.bean.UserLoginBean;

/**
 * 登陆注册Dao
 * @author lkt
 *
 */
public interface ILoginAndRegisterDao {
	/**
	 * 登陆时，查询账户的密码
	 * @param tel
	 * @return
	 */
	public String selectPass(String account);

	/**
	 * 注册，登陆表插入新信息
	 * @param UserLoginBean.tel
	 * @param UserLoginBean.pass
	 * @return
	 */
	public void insertLogin(UserLoginBean bean);

	/**
	 * 注册，用户信息表插入新信息
	 * @param UserInfoBean bean
	 * @return
	 */
	public void insertInfo(UserInfoBean bean);

	/**
	 * 通过登陆主键id，修改密码
	 * @param UserInfoBean的属性id
	 */
	public void updatePass(@Param("pass")String pass,@Param("account")String account);

	/**
	 * 通过手机号，查询用户信息
	 * @param UserInfoBean的
	 */
	public UserInfoBean selectInfor(String account);

	/**
	 * 通过外键，修改用户信息的邮件
	 * @param UserInfoBean的实例
	 */
	public void updateInfor(@Param("mail")String mail,@Param("account")String account);

	/**
	 * 通过用户账号（手机号）查询用户是否有评论权利
	 * @param UserLoginBean.tel
	 * @return
	 */
	public Integer userComment(String account);

	/**
	 * 通过用户账号（手机号）关闭用户是评论权利
	 * @param UserLoginBean.tel
	 * @return
	 */
	public void closeComment(String account);

	/**
	 * 通过用户账号（手机号）打开用户是评论权利
	 * @param UserLoginBean.tel
	 * @return
	 */
	public int  openComment(String account);

	/**
	 * 通过用户账号（手机号）查询用户信息
	 * @param UserLoginBean.tel
	 * @return
	 */
	public UserInfoBean selectUserBean(String account);
}
