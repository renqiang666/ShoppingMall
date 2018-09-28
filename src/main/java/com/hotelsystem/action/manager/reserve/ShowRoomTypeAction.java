package com.hotelsystem.action.manager.reserve;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hotelsystem.bean.RoomTypeBean;
import com.hotelsystem.service.manager.suppermanager.IRoomTypeService;
/**
 * 
 * @ClassName: ShowRoomTypeAction 
 * @Description: TODO
 * @author jhz
 * @date 2018年8月12日 下午2:34:23 
 * @version v1.0
 */
@Controller
public class ShowRoomTypeAction {
	@Autowired
	private IRoomTypeService service;
	
	/**
	 * 
	 * @Title: showRoomTypeWhereReserve 
	 * @Description: TODO
	 * @param @return
	 * @return ModelAndView
	 * @throws
	 */	
	@RequestMapping(value="/showRoomTypeByManager.action")
	public ModelAndView showRoomTypeWhereReserve(){
		ModelAndView model=new ModelAndView();
		List<RoomTypeBean> list = service.findRoomType();
		model.addObject("list",list);
		model.setViewName("admin/addReserve.jsp");
		return model;
		
	}
}
