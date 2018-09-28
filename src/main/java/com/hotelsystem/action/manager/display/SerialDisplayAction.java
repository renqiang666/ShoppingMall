package com.hotelsystem.action.manager.display;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.SerialBean;
import com.hotelsystem.service.manager.search.ISerialDisplayService;



@Controller
public class SerialDisplayAction {
	@Autowired
	private ISerialDisplayService serialDisplayService;
	
	@RequestMapping("/SerialDisplayAction_display.action")
	public String  display(){
		
		return "/admin/serialdisplay.jsp";
	}
	
	
	@RequestMapping("/findSerial.action")
	public @ResponseBody PageInfo findByTime(int pageNum,String startDate,String endDate){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date minDate=null;
		Date maxDate=null;
		try {
			minDate = sdf.parse(startDate+":00");
			maxDate=sdf.parse(endDate+":00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		PageInfo page=serialDisplayService.findSerialByTime(pageNum,minDate, maxDate);
		System.out.println(page.isHasNextPage());
		return page;
	}
	
	@RequestMapping("/displayAllSerial.action")
	public @ResponseBody PageInfo findAll(@RequestParam Integer pageNum){
		PageInfo page = serialDisplayService.findAll(pageNum);
		return page;
	}
}
