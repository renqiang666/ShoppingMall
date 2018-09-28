package com.hotelsystem.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelsystem.bean.UserInfoBean;
import com.hotelsystem.dao.ILoginAndRegisterDao;
import com.hotelsystem.service.user.IChangeInfoService;
import com.hotelsystem.utils.AesEncodeUtil;

@Service
public class ChangeInfoServiceImpl implements IChangeInfoService {
	@Autowired
	private ILoginAndRegisterDao dao;
	//淇敼瀵嗙爜
	@Override
	public String changePass(String pass, String account) {
		String result="pass change failed";
		String realPass="";
		//楠岃瘉鎵嬫満鍙锋牸寮�
		if(pass==null ){
			result="pass was wrong";
			return result;
		}else if(pass.equals("")){
			result="please write pass";
			return result;
		}
		else if(!(pass.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$"))){
			result="Incorrect password format";
			return result;
		}
		//鍔犲瘑
		String aesPass="";
		try {
			aesPass=AesEncodeUtil.aesEncrypt(pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		鍙栧嚭璐﹀彿鐪熷疄瀵嗙爜锛屼簬鏂板瘑鐮佽繘琛屽姣�
//		SqlSession session=MybatisUtil.getSqlSession(true);
//		ILoginAndRegisterDao dao=session.getMapper(ILoginAndRegisterDao.class);
		realPass=dao.selectPass(account);
		if(realPass.equals(aesPass)){
			result="The old and new passwords cannot be the same. Please enter again";
		}else{
			dao.updatePass(aesPass, account);
			result="Password updated successfully";
		}
//		session.close();
		return result;
	}
//	淇敼鎵嬫満鍙�
	@Override
	public String changeAccount(String account, int id) {
		// TODO Auto-generated method stub
		return null;
	}
//淇敼閭
	@Override
	public String changeMail(String mail, String account) {
//		楠岃瘉鏍煎紡
		String result="emil change failed";
		 if(mail==null){
			return result;
		 }else if(mail.equals("") ){
			result="email can't null";
			return result;
		}else if(!(mail.matches("^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$"))){
			result="Wrong email format";
			return result;
		}
		try{
			dao.updateInfor(mail, account);
			result="Email updated successfully";
		}catch (Exception e) {
			result="emil change failed";
		}
		
		return result;
	}
	
	@Override
	public UserInfoBean showInfo(String account) {
		UserInfoBean bean=dao.selectUserBean(account);
		return bean;
	}

}
