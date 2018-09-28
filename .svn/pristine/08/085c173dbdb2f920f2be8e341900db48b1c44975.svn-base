package com.hotelsystem.action.manager.suppermanager;

import com.hotelsystem.bean.SerialBean;
import com.hotelsystem.service.manager.suppermanager.ISerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ConsumeAction
 * @Description TODO
 * @Author Wu Yimin
 * @Date 2018/8/9 上午9:35
 * @Version 1.0
 **/
@Controller
public class ConsumeAction {
    @Autowired
    private ISerialService ISerialService;


    @RequestMapping("/CheckCounsume.action")
    public @ResponseBody
    String CheckCounsume(@RequestBody SerialBean serialBean) {
        String res= ISerialService.insert(serialBean);
        return res;
    }

}
