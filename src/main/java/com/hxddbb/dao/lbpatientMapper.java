package com.hxddbb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.entity.lbpatient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface lbpatientMapper extends BaseMapper<lbpatient> {

    Page<lbpatient> selectlist(Page page,@Param("lbt") lbpatient lbt);//多表查询，base里面没有sql语句，自定义接口加xml sql语句

//查询病人,把动态代理接口与数据库sql语句对接，sql语句已写好，条件是查询用户输入的身份证id
//    lbpatient select(@Param("cert_id") String sfzid);

    lbpatient selectByPrimaryKey(String sfzid);

    //查询所有病人[非多表查询，select*]
    List<lbpatient>selectall();


    //根据user_id查询，方便用户登录按照自己的登录号识别
    lbpatient selectpatient(@Param("userId") Integer id);

    //注册过后更新用户id为病人表的userid，由于用户只输入的身份证账号密码，条件是身份证
    //注册病人用户，同时把注册的id更新到病人表当中的userid字段
     void updatauser(@Param("lbt") lbpatient lbpt);
}