
package com.hotelsystem.service.manager.reserve;

import java.util.List;
import com.hotelsystem.bean.SerialBean;
public interface SerialService{

    int insert(SerialBean serialBean);

    int insertSelective(SerialBean serialBean);

    int insertList(List<SerialBean> serialBeans);

    int update(SerialBean serialBean);
}
