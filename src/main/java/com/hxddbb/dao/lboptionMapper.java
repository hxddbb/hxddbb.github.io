package com.hxddbb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxddbb.entity.lboption;
import org.apache.ibatis.annotations.Mapper;
import org.beetl.sql.core.annotatoin.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface lboptionMapper extends BaseMapper<lboption> {
    //查询所有
    List<lboption> selectall();


    //根据检查项，计算费用
    BigDecimal getTotalPrice(@Param("ids") List<Integer> ids);
}