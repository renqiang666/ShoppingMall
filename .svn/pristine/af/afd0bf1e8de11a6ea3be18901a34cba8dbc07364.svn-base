package com.hotelsystem.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyuncs.exceptions.ClientException;
import com.hotelsystem.dao.ILoginAndRegisterDao;
import com.hotelsystem.service.user.ISendMessageCodeService;
import com.hotelsystem.utils.SendMessageCode;

@Service
public class SendMessageCodeServiceImp implements ISendMessageCodeService {
	@Autowired
	private ILoginAndRegisterDao dao;
	
	//登陆验证码
	@Override
	public String loginCode(String tel) {
		//发送验证码
		String code="";
		int j=10;
		for(int i=0;i<6;i++){
			j=(int) (Math.random()*10);
			code+=j;
		}
		try {
			SendMessageCode.sendCode(tel,code,"SMS_141660009");
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
	}

	//注册验证码
	@Override
	public String registerCode(String tel) {
		//发送验证码
		String code="";
		int j=10;
		for(int i=0;i<6;i++){
			j=(int) (Math.random()*10);
			code+=j;
		}
		try {
			SendMessageCode.sendCode(tel,code,"SMS_141635004");
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
	}

	//找回密码验证码
	@Override
	public String findPassCode(String tel) {
		//发送验证码
		String code="";
		int j=10;
		for(int i=0;i<6;i++){
			j=(int) (Math.random()*10);
			code+=j;
		}
		try {
			SendMessageCode.sendCode(tel,code,"SMS_141655003");
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
	}
	
	//判断是否存在此用户
	@Override
	public  String judgeAccount(String account){
		//格式验证
		String result="it's not a tel";
		if(account==null || account.equals("")){
			result="can't null";
			return result;
		}else if(!(account.matches("^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$"))){
			result="it's not a tel";
			return result;
		}
		//判断有无此账号
//		SqlSession session=MybatisUtil.getSqlSession(true);
//		ILoginAndRegisterDao dao=session.getMapper(ILoginAndRegisterDao.class);
		if(dao.selectPass(account)!=null){
			result="存在此账号";
		}else{
			result="This account does not exist";
		}		
		return result;
	}
	
	//换绑手机验证码
	@Override
	public String changeTelCode(String tel) {
		
		return null;
	}

}
