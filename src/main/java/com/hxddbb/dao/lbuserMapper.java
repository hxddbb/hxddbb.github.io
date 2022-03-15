package com.hxddbb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxddbb.entity.lbdoctor;
import com.hxddbb.entity.lbuser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface lbuserMapper extends BaseMapper<lbuser> {

//    int insert(lbuser record);

    lbuser selectByusername(String username);


//    int updateByPrimaryKey(lbuser record);
}