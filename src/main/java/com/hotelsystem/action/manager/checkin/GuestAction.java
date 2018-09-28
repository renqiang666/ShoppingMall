package com.hotelsystem.action.manager.checkin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hotelsystem.bean.GuestBean;
import com.hotelsystem.service.manager.checkin.IGuestService;

/**
 *@ClassName GuestAction
 *@Description TODO:
 *@Author Li Gen
 *@Date 2018年8月17日 下午2:40:52
 *@Version 1.0
 **/
@Controller(value="guest1")
public class GuestAction {
	@Autowired
	private IGuestService service;
	@RequestMapping("/addGuest.action")
	public ModelAndView addGuest(GuestBean bean){
		service.addGuest(bean.getRoom().getId(), bean);
		ModelAndView model =new ModelAndView();
		model.setViewName("/findAllByPage.action");
		return model;
	}
	@RequestMapping("/delGuest.action")
	public ModelAndView delGuest(Integer rid){
		service.delGuest(rid);
		ModelAndView model =new ModelAndView();
		model.setViewName("/findAllByPage.action");
		return model;
	}

}
