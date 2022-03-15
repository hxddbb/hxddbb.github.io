package com.hxddbb.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.Service.appointmentservice;
import com.hxddbb.dao.lbappointmentMapper;
import com.hxddbb.entity.lbappointment;
import com.hxddbb.vo.QueryVo;
import com.hxddbb.vo.resultresponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class appointmentserviceImpl implements appointmentservice {
    @Resource
    private lbappointmentMapper lapmapper;
    @Override
    public Page<lbappointment> findlist(QueryVo queryVo) {
      Page<lbappointment> page=new Page<>(queryVo.getPageNo(),queryVo.getPageSize());
        QueryWrapper<lbappointment> query = new QueryWrapper<>();

//        if (!StringUtils.isEmpty(queryVo.getPatientName())){
//
////           在sql中已经做了判断
//        }if (!StringUtils.isEmpty(queryVo.getDoctorName())) {
//        if (queryVo.getUserId() != null) {
//           page.set
//        }
        if (queryVo.getPageNo()>0&&queryVo.getPageSize()>0){

            return lapmapper.selectlist(page,queryVo);

        }
        return null;}

    @Override//这个方法用于医生客户端里面
    public Page<lbappointment> findDoctor(QueryVo queryVo){
        Page<lbappointment> page=new Page<>(queryVo.getPageNo(),queryVo.getPageSize());
        return lapmapper.selectListByDoctor(page,queryVo);
    }


    @Override
    public resultresponse save(lbappointment lbd) {
        resultresponse rs=new resultresponse();
        lapmapper.insert(lbd);
        rs.setCode("302");
        rs.setMessage("保存成功");
        return rs;
    }

    @Override//注意这里是按主键在多表中查询，不是单表
    public lbappointment edit(Integer id) {
        return lapmapper.selectyi(id);
    }

    @Override
    public resultresponse update(lbappointment lbd) {
        resultresponse rs= new resultresponse();
        lapmapper.updateById(lbd);
        rs.setCode("302");
        rs.setMessage("更新成功");
        return rs;
    }

    @Override
    public int deleteDoctor(Integer id) {
      int nums=  lapmapper.deleteById(id);
        resultresponse rs=new resultresponse();
        if (nums>0){
            rs.setCode("401");
            rs.setMessage("删除成功");
        }else {
            rs.setCode("402");
            rs.setMessage("删除失败");
        }return nums;
    }
//插入对象返回主键，在mybatisplus里面的insert方法执行完成时已经把主键ID赋值回来给实体ID了。
// 直接在controller层取entity.getId()就行。
    @Override
    public Integer insertReturnId(lbappointment appointment) {
        return lapmapper.insert(appointment);
    }

    @Override
    public lbappointment findpatient(Integer id) {
        return lapmapper.selectpatient(id);
    }
}
