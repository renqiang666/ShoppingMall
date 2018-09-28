package com.hotelsystem.action.manager.reserve;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotelsystem.service.manager.reserve.IAddReserveSerrvice;
import com.hotelsystem.utils.SendMessageCode;

@Controller
public class AddReserveAction {
	@Autowired
	private IAddReserveSerrvice service;
	
	@RequestMapping(value="/addReserveFromManager.action")
	public @ResponseBody String addReserveFromManager(@RequestBody List<Map<String,Object>> list){
		Map<String, Object> map = service.addReserveService(list);
		String res = (String) map.get("res");
		if(res=="添加成功!"){
			String phone = (String) map.get("tel");
			String name = (String) map.get("name");
			String roomId = (String) map.get("roomId");
			if(phone!=null && name!=null && roomId!=null){
				try {
					String code = SendMessageCode.sendCodeAfterSuccess(phone, name, roomId);
					System.out.println(code);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}
}
