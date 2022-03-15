package com.hxddbb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.entity.lbmedicalhistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface lbmedicalhistoryMapper  extends BaseMapper<lbmedicalhistory> {
      Page<lbmedicalhistory> selectlist(Page page, @Param("med") lbmedicalhistory lmed);
}