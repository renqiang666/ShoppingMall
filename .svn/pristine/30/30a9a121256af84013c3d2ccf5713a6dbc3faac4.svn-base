package com.hotelsystem.service.user.impl;

import io.goeasy.GoEasy;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.aliyuncs.exceptions.ClientException;
import com.hotelsystem.action.user.RefundAction;
import com.hotelsystem.bean.ReserveNumberBean;
import com.hotelsystem.bean.ReservePeopleBean;
import com.hotelsystem.bean.ReserveRoomBean;
import com.hotelsystem.bean.RoomTypeBean;
import com.hotelsystem.dao.ICheckInPersonDao;
import com.hotelsystem.dao.IReserveNumberDao;
import com.hotelsystem.dao.IReservePeopleDao;
import com.hotelsystem.dao.IReserveRoomDao;
import com.hotelsystem.service.user.IPayMoneyService;
import com.hotelsystem.utils.AlipayConfig;
import com.hotelsystem.utils.OrderStatusEnum;
import com.hotelsystem.utils.SendMessageCode;

@Service
@Transactional
public class PayMoneyImpl implements IPayMoneyService {
	@Autowired
	private IReserveNumberDao reserveNumberDao;
	@Autowired
	private IReserveRoomDao reserveRoomDao;
	@Autowired
	private IReservePeopleDao reservePeopleDao;
	@Autowired
	private ICheckInPersonDao checkInPersonDao;
	
	final static Logger log = LoggerFactory.getLogger(RefundAction.class);
	
	@Override
	public String payMoney(String roomId) throws AlipayApiException  {
		ReserveNumberBean reserveNumberBean=reserveNumberDao.findReserveNumberById(roomId);
		RoomTypeBean roomTypeBean = reserveNumberBean.getRoomType();
		ReserveRoomBean reserveRoomBean = reserveRoomDao.findReserveRoomByRoomId(roomId);
		
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

				
		//商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = roomId;
		//付款金额，必填
		String total_amount = String.valueOf(reserveRoomBean.getMoney());
		//订单名称，必填
		String subject = roomTypeBean.getName();
		//商品描述，可空
		String body = "预定房间数量：" + reserveNumberBean.getCount();

		// 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
		String timeout_express = "15m";

		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
				+ "\"total_amount\":\""+ total_amount +"\","
				+ "\"subject\":\""+ subject +"\","
				+ "\"body\":\""+ body +"\","
				+ "\"timeout_express\":\""+ timeout_express +"\","
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

		//请求
		String result = alipayClient.pageExecute(alipayRequest).getBody();
		return result;
	}



	@Override
	public RoomTypeBean changeInfoAfterSuccess(String tel,String out_trade_no,
			String trade_no, String total_amount) {
		ReserveRoomBean bean = reserveRoomDao.findReserveRoomByRoomId(out_trade_no);
		bean.setPay(trade_no);
		bean.setState(Integer.valueOf(OrderStatusEnum.PAID.key));
		reserveRoomDao.updateAfterPay(bean);
		RoomTypeBean roomTypeBean = reserveNumberDao.findReserveNumberById(out_trade_no).getRoomType();
		
		GoEasy goEasy = new GoEasy("https://rest-hangzhou.goeasy.io","BC-fd413ae5f6ff4410a43586c6b0780ca1");
        goEasy.publish("my_channel", out_trade_no);
		
        ReservePeopleBean people = reservePeopleDao.findReservePeopleByPeopleTel(tel);
        try {
			String res = SendMessageCode.sendCodeAfterSuccess(tel, people.getName(), out_trade_no);
			System.out.println(res);
		} catch (ClientException e) {
			e.printStackTrace();
		}
		return roomTypeBean;
	}



	@Override
	public boolean refundByUser(String reserveRoomId) {
		
		/*
		 * 删除所有预订信息  
		 */
		ReserveRoomBean reserveRoomBean = reserveRoomDao.findReserveRoomByRoomId(reserveRoomId);
		reserveRoomBean.setState(Integer.valueOf(OrderStatusEnum.CANCELED.key));
		String money = String.valueOf(reserveRoomBean.getMoney());
		String pay = reserveRoomBean.getPay();
		ReservePeopleBean reservePeopleBean= reserveRoomBean.getReservePeople();
		List<ReserveRoomBean> list = reservePeopleBean.getReserveRoomList();
		boolean del = false;
		if(list.size()>1){
			int numberCount = reserveNumberDao.deleteReserveNumberByRoomId(reserveRoomId);
			int personCount = checkInPersonDao.deleteCheckInPersonByRoomId(reserveRoomId);
			int roomCount = reserveRoomDao.deleteReserveRoom(reserveRoomBean);
			if(numberCount == 0 || personCount == 0 || roomCount == 0){
				return del;
			}else{
				del = true;
			}
		}else{
			int peopleCount = reservePeopleDao.deleteReservePeople(reservePeopleBean);
			int numberCount = reserveNumberDao.deleteReserveNumberByRoomId(reserveRoomId);
			int personCount = checkInPersonDao.deleteCheckInPersonByRoomId(reserveRoomId);
			int roomCount = reserveRoomDao.deleteReserveRoom(reserveRoomBean);
			if(peopleCount==0 || numberCount == 0 || personCount == 0 || roomCount == 0){
				return del;
			}else{
				del = true;
			}
		}
		System.out.println("del"+del);
		/*
		 * 退款
		 */
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);
		
		AlipayTradeRefundModel refundModel = new AlipayTradeRefundModel();
		refundModel.setTradeNo(pay);
		refundModel.setRefundAmount(money);
		refundModel.setRefundReason("商品退款");
		AlipayTradeRefundRequest req = new AlipayTradeRefundRequest();

		req.setBizModel(refundModel);
		try {
			AlipayTradeRefundResponse res = alipayClient.execute(req);
			System.out.println(res.getMsg() + "\n");
			System.out.println(res.getBody());
			System.out.println(res.getCode());
			if(res.getCode().equals("10000") && del){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("支付宝退款错误！", e.getMessage());
			return false;
		}
	}



	

}
