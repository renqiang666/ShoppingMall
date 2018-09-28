package com.hotelsystem.service.user;

import com.hotelsystem.bean.UserInfoBean;
import com.hotelsystem.bean.UserLoginBean;

/**
 * 登陆与注册时使用的业务层
 * @author lkt
 *
 */
public interface ILoginRegisterService {
	//用户账号登陆验证
	public String accountLogin(String account,String pass,String realcode,String code);
	//手机号登陆
	public String telLogin(String realAccount,String account,String realCode,String code);
	//账户注册
	public String newUser(UserLoginBean bean1,UserInfoBean bean2);
	//检测账号是否存在
	public String isUser(String account);
	//检测注册手机号是否变更，以及验证码是否填写正确
	public String JuadgRegisterService(String registerTel,String tel,String registerCode,String code);
}
