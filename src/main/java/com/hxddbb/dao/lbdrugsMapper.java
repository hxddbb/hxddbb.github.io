package com.hxddbb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxddbb.entity.lbdrugs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface lbdrugsMapper extends BaseMapper<lbdrugs> {
 List<lbdrugs> selectall();
}