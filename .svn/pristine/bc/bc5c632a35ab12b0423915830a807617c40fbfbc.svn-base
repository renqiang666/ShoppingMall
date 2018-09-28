package com.hotelsystem.service.user.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotelsystem.bean.UserInfoBean;
import com.hotelsystem.bean.UserLoginBean;
import com.hotelsystem.dao.ILoginAndRegisterDao;
import com.hotelsystem.service.user.ILoginRegisterService;
import com.hotelsystem.utils.AesEncodeUtil;


/**
 * @ClassNmae ILoginRegisterServiceImpl
 * @author 刘开庭
 * @Descrption TODO
 * @Date 2018/8/7
 * @version 1.0
 */

@Service
public class LoginRegisterServiceImpl implements ILoginRegisterService{
	@Autowired
	private ILoginAndRegisterDao dao;



	//账号登录验证
	@Override
	public String accountLogin(String account, String pass,String realcode,String code) {
		String result="longin failed";
		String realPass=null;
		//对输入信息基本的格式检测
		if(account==null ||pass==null ||code==null){
			return result;
		}else if(account.equals("")){
			result="tel can't null";
			return result;
		}else if(pass.equals("")){
			result="pass can't null";
			return result;
		}else if(code.equals("")){
			result="code can't null";
			return result;
		}else if(!(realcode.equals(code))){
			result="code was wrong,please enter again";
			return result;
		}else if(!(account.matches("^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$"))){
			result="it's not atel";
			return result;
		}else if(!(pass.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$"))){
			result="Passwords do not conform to the rules";
			return result;
		}
		//对密码进行加密
		String aesPass="";
		try {
			aesPass=AesEncodeUtil.aesEncrypt(pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		realPass=dao.selectPass(account);
		//对加密的密码验证
		if(realPass==null){
			result="此账号不存在";
			return result;
		}else if(!(realPass.equals(aesPass))){
			result="pass was wrong";
			return result;
		}else if(realPass.equals(aesPass)){
			result="登陆成功";
		}
		return result;
	}
	
	
	//手机登陆验证
	@Override
	public String telLogin(String realAccount,String account, String realCode,String code) {
		String result="longin failed";
		//检测手机号是否变更，验证码是否正确
		if(code==null||code.equals("")){
			result="code can't null";
			return result;
		}else if(account==null||account.equals("")){
			result="tel can't null";
			return result;
		}else if(!(realAccount.equals(account))){
			result="Verification code timeout";
			return result;
		}else if(!(realCode.equals(code))){
			result="code was wrong";
			return result;
		}
		if(realCode.equals(code) && realAccount.equals(account)){		
				result="登陆成功";
				return result;
		}
		return result;
	}
	//新增用户
	
	@Override
	@Transactional
	public String newUser(UserLoginBean bean1, UserInfoBean bean2) {
		String result="register failed";
		String pass=null;
		//对输入信息基本的格式检测
		if(bean1.getAccount()==null
				||bean1.getPass()==null
				||bean2.getIden()==null
				||bean2.getName()==null
				||bean2.getEmail()==null){
			return result;
		}else if(bean1.getAccount().equals("")){
			result="account can't null";
			return result;
		}else if(!(bean1.getAccount().matches("^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$"))){
			result="it's not a tel";
			return result;
		}else if(bean1.getPass().equals("")){
			result="pass can't null";
			return result;
		}else if(!(bean1.getPass().matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$"))){
			result="Incorrect password format";
			return result;
		}else if(bean2.getName().equals("")){
			result="name can't null";
			return result;
		}else if(bean2.getIden().equals("")){
			result="iden can't null";
			return result;
		}else if( !(bean2.getEmail().equals("")) 
				&& !(bean2.getEmail().matches("^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$"))){
			result="Wrong email format";
			return result;
		}else if(!(bean2.getIden().matches("(^\\d{18}$)|(^\\d{15}$)"))){
			result="Wrong iden format";
			return result;
		}
		
		pass=dao.selectPass(bean1.getAccount());
		//检测账号是否被注册
		if(pass==null){
			//对注册密码进行加密
			String aesPass="";
			try {
				aesPass=AesEncodeUtil.aesEncrypt(bean1.getPass());
			} catch (Exception e) {
				e.printStackTrace();
			}
			bean1.setPass(aesPass);
			dao.insertLogin(bean1);
			bean2.setUlb(bean1);
			//
			dao.insertInfo(bean2);
			result="注册成功";
		}else{
			result="该账号已被使用";
		}
		return result;
	}

//	判断是否存在此用户
	@Override
	public String isUser(String account) {
		String result="tel was wrong";
		String pass=null;
		//对输入信息基本的格式检测
		if(account==null ||account.equals("")){
			return result;
		}else if(!(account.matches("^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$"))){
			result="Wrong tel format";
			return result;
		}
		pass=dao.selectPass(account);

		if(pass!=null){
			result="存在此账号";
		}else{
			result="不存在此账号";
		}
		return result;
	}


	@Override
	public String JuadgRegisterService(String registerTel, String tel, String registerCode, String code) {
		String result="Verification code timeout or tel was wrong";
		if(registerTel==null || registerCode==null){
			result="please writing tel first";
			return result;
		}else if(!(registerTel.equals(tel))){
			result="tel has changed,please getting code agin";
			return result;
		}else if(!(registerCode.equals(code))){
			result="code was wrong";
			return result;
		}
		if(registerTel.equals(tel) && registerCode.equals(code)){
			result="ok";
		}
		return result;
	}

}

