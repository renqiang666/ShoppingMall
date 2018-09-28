package com.hotelsystem.action.manager.suppermanager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hotelsystem.service.manager.suppermanager.IManagerRecordService;


@Controller
public class ManagerRecordAction {
	@Autowired
	private IManagerRecordService service;
	@RequestMapping(value="/recordAction.action")
	public @ResponseBody PageInfo recordAction(Integer current){
		PageInfo page=service.findAllManagerRecord(current);
		return page;
	}
	@RequestMapping(value="/findTimeAction.action")
	public @ResponseBody PageInfo findTimeAction(String date,Integer current){
		System.out.println(date);
		System.out.println(current);
		PageInfo page=service.findManagerRecordByDate(date, current);
		return page;
	}
}