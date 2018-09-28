package com.hotelsystem.action.manager.display;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.RoomInfoBean;
import com.hotelsystem.service.manager.search.IRoomDisplayService;


@Controller
public class RoomDisplayAction {
	
	@Autowired
	private IRoomDisplayService roomDiplayService;
	
	@RequestMapping("/RoomDisplayAction_findRoomInfoByType.action")
	public @ResponseBody PageInfo findRoomInfoByType(int pageNum,int type){
		PageInfo page=null;
		if(type==5){
			page=roomDiplayService.findAllRoomInfo(pageNum);
		}else{
			page=roomDiplayService.findAllRoomInfoByType(pageNum,type);
		}
		return page;
	}
	
	@RequestMapping("/RoomDisplayAction_index.action")
	public String roomDisplay(){
		return "/admin/roomdisplay.jsp";
	}
}
