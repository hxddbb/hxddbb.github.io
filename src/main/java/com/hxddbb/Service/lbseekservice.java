package com.hxddbb.Service;

import com.hxddbb.entity.lbseek;
import com.hxddbb.vo.resultresponse;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface lbseekservice {

    //保存记录
    resultresponse save(Map map, HttpSession session);

    //更新记录
    resultresponse  update(Map map, HttpSession session);

    //获取一条记录
    lbseek findOneByPatientId(Integer patientId, Integer appointmentId, HttpSession session);

//根据预约id获取当前操作的预约号，好按部就位添加看病表
    lbseek findappointmentid(Integer appointmentId);
}
