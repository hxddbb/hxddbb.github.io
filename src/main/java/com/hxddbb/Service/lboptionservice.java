package com.hxddbb.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.entity.lboption;
import com.hxddbb.vo.resultresponse;

import java.util.List;

public interface lboptionservice {
    Page<lboption> findlist(Integer pageNo,Integer pageSize,String name,String type);//分页

    resultresponse save(lboption lbp);//保存

    lboption edit(Integer id);//查询

    resultresponse update(lboption lbp);//更新

    int del(Integer id);//根据主键删除

    List<lboption> findall();
}
