package com.hxddbb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.entity.lbhospitalization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface lbhospitalizationMapper extends BaseMapper<lbhospitalization> {

    Page<lbhospitalization> selectlist(Page page, @Param("hsp") lbhospitalization lb);

    List<lbhospitalization> selectall();

    List<lbhospitalization> selectonepatient(Integer userid);//根据病人表用户id连接住院表病人id,获取病人名
}