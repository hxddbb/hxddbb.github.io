package com.hxddbb.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hxddbb.Service.lbseekservice;
import com.hxddbb.common.DrugsUtils;
import com.hxddbb.common.Global;
import com.hxddbb.common.OptionUtils;
import com.hxddbb.dao.lbappointmentMapper;
import com.hxddbb.dao.lbdrugsMapper;
import com.hxddbb.dao.lboptionMapper;
import com.hxddbb.dao.lbseekMapper;
import com.hxddbb.entity.lbappointment;
import com.hxddbb.entity.lbseek;
import com.hxddbb.vo.resultresponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;
@Transactional
@Service
public class lbseekserviceImpl implements lbseekservice {
    @Resource
    private lbappointmentMapper appserdao;
    @Resource
    private lboptionMapper optiondao;
    @Resource
    private lbdrugsMapper drugsdao;
    @Resource
    private lbseekMapper lbseekdao;

    @Override
    public resultresponse save(Map map, HttpSession session) {
        Integer appointmentId = Integer.valueOf(String.valueOf(map.get("appointmentId")));//前端医生用户进行操作的预约号
//        Query<lbseek> query = lbSeekDao.createQuery();
//        query.andEq("appointment_id",appointmentId);
//        lbseek seek = query.single();
//        QueryWrapper<lbseek> query = new QueryWrapper<>();
//        query.lambda().eq(lbseek::getAppointmentId, appointmentId);//当前预约号
        lbseek seek = lbseekdao.selectappointmentid(appointmentId);//当前预约号
        if (seek == null) {
            seek = new lbseek();
            seek.setPatientId(Integer.valueOf(String.valueOf(map.get("patientId"))));
            seek.setDays(Integer.valueOf(String.valueOf(map.get("days"))));
            seek.setDescribes(String.valueOf(map.get("describes")));
            seek.setIllname(String.valueOf(map.get("illname")));
            seek.setOptions(OptionUtils.getOptionIds(map));
            seek.setAppointmentId(Integer.valueOf(String.valueOf(map.get("appointmentId"))));
            //插入医生用户选择的数据
            seek.setPrice(optiondao.getTotalPrice(OptionUtils.getOptionIds(seek.getOptions())));
            lbseekdao.insert(seek);
            //根据检查项，计算出所需的费用,更新进去【返回值不同不能一并插入】
//            lbseek seek2 = new lbseek();
//            seek2.setId(seek.getId());
//            seek.setPrice(optiondao.getTotalPrice(OptionUtils.getOptionIds(seek.getOptions())));
//            lbseekdao.updateprice(seek);

            //修改预约记录状态
            lbappointment appointment = new lbappointment();
            appointment.setId(Integer.valueOf(String.valueOf(map.get("appointmentId"))));
            appointment.setStatus(Global.SEEK_CODE_PROCESSING);
            appserdao.updateById(appointment);

//            //将新记录的id存储到session中
            session.setAttribute("seek_" + map.get("patientId"), seek.getId());
              return new resultresponse(Global.SAVE_CODE_SUCCESS, Global.SAVE_MSG_SUCCESS);}
        else{ return new resultresponse(Global.SAVE_MSG_ERROR, Global.SEEK_MSG_EXIST); }

 }

 //配药，获取医生用户选择的信息，再根据病单主键更新
    @Override
    public resultresponse update(Map map, HttpSession session) {
        Integer seekId = (Integer) session.getAttribute("seek_" + map.get("patientId"));
        lbseek seek = new lbseek();
        seek.setId(seekId);
        seek.setDrugs(DrugsUtils.getDrugsInfo(map));
        lbseekdao.updatedrugs(seek);
        return new  resultresponse(Global.SAVE_CODE_SUCCESS,Global.SAVE_MSG_SUCCESS);
    }

    @Override
    public lbseek findOneByPatientId(Integer patientId, Integer appointmentId, HttpSession session) {
        lbseek seek = null;
        Integer seekId = (Integer) session.getAttribute("seek_" + patientId);
        if (seekId!=null){//如果当前回话中插入就诊记录，可以从session中获取就诊id
            seek = lbseekdao.selectById(seekId);
        }else { //反之，就诊记录已经存在，根据预约编号查询
            QueryWrapper<lbseek> query=new QueryWrapper<>();
//            query.andEq("appointment_id",appointmentId);
            query.lambda().eq(lbseek::getAppointmentId,appointmentId);
            seek = lbseekdao.selectOne(query);
        }
        return seek;
    }

    @Override
    public lbseek findappointmentid(Integer appointmentId) {
        return lbseekdao.selectappointmentid(appointmentId);
    }
}

