package com.hotelsystem.action.manager.suppermanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hotelsystem.service.manager.suppermanager.IMenmbersService;


@Controller(value="members1")
public class MenmbersAction {
	@Autowired
	private IMenmbersService service;
	//查询全部会员信息action
	@RequestMapping(value="/showMenmbersAction.action")
	public @ResponseBody PageInfo showMenmbersAction(int current){
		PageInfo page =service.checkAllMenmbers(current);
		return page;
	}
	//添加会员信息action
	@RequestMapping(value="/addMenmbersAction.action")
	public @ResponseBody String addMenmbersAction(String mid,String mname){
		String result=service.addMenmbers(mid, mname);
		return result;
	}
	//删除会员信息
	@RequestMapping(value="/delMenmbersAction.action")
	public @ResponseBody String delMenmbersAction(String mid){
		String result=service.delMenmbers(mid);
		return result;
	}
}
