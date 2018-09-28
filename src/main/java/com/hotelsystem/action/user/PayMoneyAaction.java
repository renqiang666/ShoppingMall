package com.hotelsystem.action.user;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alipay.api.internal.util.AlipaySignature;
import com.hotelsystem.bean.RoomTypeBean;
import com.hotelsystem.service.user.IPayMoneyService;
import com.hotelsystem.utils.AlipayConfig;

@Controller
public class PayMoneyAaction {
	
	final static Logger log = LoggerFactory.getLogger(PayMoneyAaction.class);
	@Autowired
	private IPayMoneyService payMoneyService;
	
	
	@RequestMapping(value = "/goAlipay.action", produces = "text/html; charset=UTF-8")
	public ModelAndView goAlipay(HttpServletRequest req) throws Exception{
		String reserveRoomId = (String) req.getSession().getAttribute("reserveRoomId");
		ModelAndView model = new ModelAndView();
		String result = payMoneyService.payMoney(reserveRoomId);
		model.addObject("result", result);
		model.setViewName("user/alipay.jsp");
		return model;
	}
	
	/**
	 *
	 * @Title: AlipayController.java
	 * @Package com.sihai.controller
	 * @Description: 支付宝同步通知页面
	 * Copyright: Copyright (c) 2017
	 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
	 *
	 * @author sihai
	 * @date 2017年8月23日 下午8:51:01
	 * @version V1.0
	 */
	@RequestMapping("alipayReturnNotice.action")
	public ModelAndView alipayReturnNotice(HttpServletRequest request, HttpServletRequest response) throws Exception {

		log.info("支付成功, 进入同步通知接口...");

		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		//调用SDK验证签名
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);

		ModelAndView mv = new ModelAndView("user/alipaySuccess.jsp");
		//——请在这里编写您的程序（以下代码仅作参考）——
		if(signVerified) {
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

			//支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

			//付款金额
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");

			// 修改订单状态，改为 支付成功，已付款; 同时新增支付流水
			HttpSession session = request.getSession(true);
			String tel = (String) session.getAttribute("account");
			RoomTypeBean roomTypeBean = payMoneyService.changeInfoAfterSuccess(tel,out_trade_no, trade_no, total_amount);
			
		log.info("********************** 支付成功(支付宝同步通知) **********************");
   		log.info("* 订单号: {}", out_trade_no);
   		log.info("* 支付宝交易号: {}", trade_no);
   		log.info("* 实付金额: {}", total_amount);
   		log.info("* 购买产品: {}", roomTypeBean.getName());
   		log.info("***************************************************************");
   		mv.addObject("out_trade_no", out_trade_no);
   		mv.addObject("trade_no", trade_no);
   		mv.addObject("total_amount", total_amount);
   		mv.addObject("productName", roomTypeBean.getName());
   		
		}else {
			log.info("支付, 验签失败...");
			mv.setViewName("user/404.jsp");
		}
		return mv;
	}

}
