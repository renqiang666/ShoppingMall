package com.hotelsystem.action.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotelsystem.service.user.IPayMoneyService;

@Controller
public class RefundAction {
	
	@Autowired
	private IPayMoneyService pay;

	@RequestMapping(value = "/refundOrder.action")
	public @ResponseBody boolean refundOrder(@RequestParam String reserveRoomId){
		boolean bo = pay.refundByUser(reserveRoomId);
		return bo;
	}
}
