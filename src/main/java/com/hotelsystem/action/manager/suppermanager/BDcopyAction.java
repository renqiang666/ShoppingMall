package com.hotelsystem.action.manager.suppermanager;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotelsystem.bean.DBbean;
import com.hotelsystem.service.manager.suppermanager.IDBcopyService;
@Controller
public class BDcopyAction {

	@Autowired
    private IDBcopyService cservice;
	
	@RequestMapping(value="/LocalDBcopy.action")
	public @ResponseBody String LocalBDcopy(HttpServletRequest req,String path){
		System.out.println("LocalDBcopy.action");
		//设置数据库路径
		DBbean bean=new DBbean("localhost","root","root");

		String result=cservice.backup(path, "hotelsystem", bean);

		return result;
	}
	@RequestMapping(value="/ServerDBcopy.action")
	public @ResponseBody String ServerBDcopy(HttpServletRequest req){
		//设置数据库路径
		DBbean bean=new DBbean("localhost","root","root");
		ServletContext context = req.getServletContext();
		String path = context.getRealPath("/HotelManagementSQL");
		String result=cservice.backup(path, "hoteltest", bean);
		return result;
	}
}
