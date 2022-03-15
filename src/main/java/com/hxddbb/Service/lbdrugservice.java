package com.hxddbb.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.entity.lbdrugs;
import com.hxddbb.vo.resultresponse;

import java.util.List;

public interface lbdrugservice {

    Page<lbdrugs> finddoctorlist(Integer  pageNo, Integer pageSize, String name, Integer type);//查询
    
    resultresponse save(lbdrugs lbd);//保存（Insert）

    lbdrugs edit(Integer id);//编辑（查询）

    resultresponse update(lbdrugs lbd);//更新

    int deleteDoctor(Integer id);//删除

    List<lbdrugs>findall();
}
