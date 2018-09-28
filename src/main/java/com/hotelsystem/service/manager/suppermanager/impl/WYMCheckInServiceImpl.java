package com.hotelsystem.service.manager.suppermanager.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.CheckInBean;
import com.hotelsystem.bean.HotelDiscountBean;
import com.hotelsystem.bean.MenmbersBean;
import com.hotelsystem.dao.ICheckInDao;
import com.hotelsystem.service.manager.suppermanager.ICheckInService;
import com.hotelsystem.utils.AesEncodeTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @ClassName CheckInServiceImpl
 * @Description TODO
 * @Author Wu Yimin
 * @Date 2018/8/9 下午2:40
 * @Version 1.0
 **/
@Service
@Transactional
public class WYMCheckInServiceImpl implements ICheckInService {
    @Autowired
    private ICheckInDao checkInDao;

    /**
     * 查询所有房间号
     *
     * @return
     */
    @Override
    public PageInfo queryAll(int pageNum) {
        //获取第1页2条内容
        PageHelper.startPage(pageNum, 2);
        //接着的方法会被分页
        List<CheckInBean> checkInBeans = checkInDao.findAllCheckIn();
        //page里面包含了分页的信息
        PageInfo page = new PageInfo(checkInBeans);
        return page;
    }

    /**
     * 查询id入住信息
     *
     * @param id
     */
    @Override
    public CheckInBean queryById(String id) {
        CheckInBean checkInBean = checkInDao.findById(id);
        return checkInBean;
    }

    @Override

    public double judgeMoeny(int overTime, double money, CheckInBean checkInBean, HotelDiscountBean hotelDiscountBean) {

        if (overTime > 1) {
            money = money - checkInBean.getPaidMoney() + checkInBean.getRoom().getRoomType().getPrice();
            if (hotelDiscountBean != null) {
                money = money * hotelDiscountBean.getValue();
            }
        } else {
            money = checkInBean.getRoom().getRoomType().getPrice();
        }

        money = money - checkInBean.getPledgeMoney();
        return money;
    }

    @Override
    public String judgePaidMoney(MenmbersBean menmbersBean, String money,double lev) {
        double memberCount = 1;

        if (menmbersBean != null) {
            if (isNumeric(money)) {
                memberCount = menmbersBean.getLb().getClassDiscount();
                money = String.valueOf((Double.parseDouble(money)) * memberCount);
                // res= iMenmbersService.autoUpgrade(money, phone);
            }
        } else {
        }
        try {
            money = AesEncodeTUtil.encryptAES(String.valueOf(money));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return money;
    }

    @Override
    public String judgeRes(MenmbersBean menmbersBean) {
        if(menmbersBean!=null){
            return "";
        }
        return "输入的手机号没有会员优惠";
    }

    @Override
    public double findLev(MenmbersBean menmbersBean) {

        if(menmbersBean!=null){
            return menmbersBean.getLb().getClassDiscount();
        }
        return 1.0;
    }

    @Override
    public int deleteCheckIn(String ci_id) {
       int i= checkInDao.deleteCheckIn(ci_id);
       return i;
    }

    public boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("^(\\-?)\\d+(\\.\\d+)?$");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}
