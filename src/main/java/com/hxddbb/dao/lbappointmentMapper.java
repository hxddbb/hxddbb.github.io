package com.hxddbb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.entity.lbappointment;
import com.hxddbb.vo.QueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface lbappointmentMapper extends BaseMapper<lbappointment>  {


//模拟条件分页，因为自带的sql没有多表连接

     Page<lbappointment> selectlist(Page page, @Param("app") QueryVo queryVo);//这里为主查表的对象

    //查询患者的预约信息关系查询对应的医生
//    Page<lbappointment> selectList(Page<lbappointment> page);

    //查询当前医生的所有预约病人
    Page<lbappointment> selectListByDoctor(Page<lbappointment> page, @Param("app") QueryVo queryVo);//这里为主查表的对象

    //根据主键查询
    lbappointment selectyi(Integer id);//这里为主查表的对象id【主键】

    //根据病人id查询预约记录
    lbappointment selectpatient(@Param("patientid") Integer id);
}