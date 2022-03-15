package com.hxddbb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxddbb.entity.lbdoctor;
import com.hxddbb.entity.lbnews;

public interface lbnewsMapper  extends BaseMapper<lbnews> {
    int deleteByPrimaryKey(Integer id);

    int insert(lbnews record);

    int insertSelective(lbnews record);

    lbnews selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(lbnews record);

    int updateByPrimaryKeyWithBLOBs(lbnews record);

    int updateByPrimaryKey(lbnews record);
}