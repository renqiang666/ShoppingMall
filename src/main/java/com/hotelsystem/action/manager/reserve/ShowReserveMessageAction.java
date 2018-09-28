package com.hotelsystem.action.manager.reserve;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.ViewReserveRoomBean;
import com.hotelsystem.service.manager.reserve.IFindReserveService;

@Controller
public class ShowReserveMessageAction {
	@Autowired
	private IFindReserveService service;
	
	@RequestMapping(value="/showReserveMessage.action")
	public @ResponseBody PageInfo showAll(@RequestParam Integer current){
		PageInfo page = service.findAll(current);
		return page;
	}
	
	@RequestMapping(value="/showReserveMessageByName.action")
	public @ResponseBody PageInfo showMessageByName(@RequestParam Integer currentPage,@RequestParam String param){
		PageInfo page = service.findReserveRoomByName(currentPage,param);
		return page;
	}
	
	@RequestMapping(value="/showReserveMessageById.action")
	public @ResponseBody PageInfo showMessageById(@RequestParam Integer currentPage,@RequestParam String param){
		PageInfo page  = service.findReserveRoomById(currentPage,param);
		return page;
	}
	
	@RequestMapping(value="/showReserveMessageDetail.action")
	public ModelAndView showMessageDetail(String id,Integer reservePeopleId,HttpServletRequest req){
		HttpSession session = req.getSession(true);
		session.setAttribute("reserveRoomId", id);
		session.setAttribute("reservePeopleId", reservePeopleId);
		ModelAndView model = new ModelAndView();
		Map<String, Object> map = service.findMsgByRoomIdAndPeopleId(id, reservePeopleId);
		model.addObject("map",map);
		model.setViewName("admin/detail_reserve.jsp");
		return model;
	}
	
}
