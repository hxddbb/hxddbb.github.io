package com.hxddbb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxddbb.entity.lbseek;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface lbseekMapper extends BaseMapper<lbseek> {
    lbseek selectappointmentid(Integer appointmentId);

    void insertprice(@Param("ids") lbseek seek);

    void updatedrugs(@Param("ids") lbseek seek);
}