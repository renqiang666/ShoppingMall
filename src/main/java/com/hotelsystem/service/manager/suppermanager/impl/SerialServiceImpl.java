
package com.hotelsystem.service.manager.suppermanager.impl;

import com.hotelsystem.dao.*;
import com.hotelsystem.utils.AesEncodeTUtil;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.hotelsystem.bean.SerialBean;
import com.hotelsystem.service.manager.suppermanager.ISerialService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
@Transactional
public class SerialServiceImpl implements ISerialService {

    @Resource
    private ISerialDao ISerialDao;
    @Autowired
    private Sid sid;
    @Autowired
    private IRoomInfoDao roomInfoDao;
    @Autowired
    private IMenmbersDao iMenmbersDao;
    @Autowired
    private ICheckInDao iCheckInDao;
    @Autowired
    private IGuestDao guestDao;
    @Autowired
    private ILoginAndRegisterDao loginAndRegisterDao;

    @Override
    public String insert(SerialBean serialBean) {
        String seId = sid.next();
        serialBean.setSeId(seId);
        String res = "处理失败";
        String money = "";
        int re = 0;
        int moneys = 0;
        int y=1;
        int i= ISerialDao.insert(serialBean);
        System.out.println(serialBean.getSeTimeNow());
        int n = roomInfoDao.updateRoomStateById(serialBean.getSeCRoom(), 2);
        int x=iCheckInDao.deleteCheckIn(serialBean.getSeConId());
        int m=loginAndRegisterDao.openComment(serialBean.getSePhone());

        try {
            money = (AesEncodeTUtil.decryptAES(serialBean.getSePaidMoney())).trim();
            moneys = Integer.parseInt(money);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (serialBean.getSePhone() != null) {
            re = iMenmbersDao.updateConsume(moneys, serialBean.getSePhone());
        }
        if(i==1 && n==1 && x==1 && m==1){
            res="处理成功";
        }
        else{
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

        }
        return res;
    }

    @Override
    public int insertSelective(SerialBean serialBean) {
        return ISerialDao.insertSelective(serialBean);
    }

    @Override
    public int insertList(List<SerialBean> serialBeans) {
        return ISerialDao.insertList(serialBeans);
    }

    @Override
    public int update(SerialBean serialBean) {
        return ISerialDao.update(serialBean);
    }
}