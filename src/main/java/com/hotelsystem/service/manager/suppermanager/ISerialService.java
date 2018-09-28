
package com.hotelsystem.service.manager.suppermanager;

import java.util.List;
import com.hotelsystem.bean.SerialBean;
public interface ISerialService {

    String insert(SerialBean serialBean);

    int insertSelective(SerialBean serialBean);

    int insertList(List<SerialBean> serialBeans);

    int update(SerialBean serialBean);
}
