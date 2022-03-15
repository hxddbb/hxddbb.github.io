package com.hxddbb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxddbb.entity.lbdoctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface lbdoctorMapper extends BaseMapper<lbdoctor> {

      lbdoctor selectByPrimaryKey(String sfzid);

    //查询医生,把动态代理接口与数据库sql语句对接，sql语句已写好，条件是查询用户输入的身份证id
//    lbdoctor select(@Param("cert_id") String sfzid);
//      Page<lbdoctor> selectlike(String name);//模糊查询

      //查找所有医生
      List<lbdoctor> selectlist();
      //按照部门查询出医生，预约表单中选择部门，对应的医生就出来了
      List<lbdoctor>selectdepartment(@Param("department") String s);

  //注册医生用户，同时把注册的id更新到医生表当中的userid字段
       void  updatadoctor(@Param("lbd")lbdoctor lbd);

      lbdoctor selectuserid(Integer userId);
}