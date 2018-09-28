package com.hotelsystem.service.user;


/**
 * 发送验证码给客户
 * @author lkt
 *
 */
public interface ISendMessageCodeService {
	//登陆验证码
	public String loginCode(String tel);
	//注册手机
	public String registerCode(String tel);
	//找回密码
	public String findPassCode(String tel);
	//手机号验证
	public String judgeAccount(String tel);
	//换绑手机
	public String changeTelCode(String tel);
}
