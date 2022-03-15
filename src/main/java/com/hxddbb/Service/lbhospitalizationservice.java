package com.hxddbb.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.entity.lbhospitalization;
import com.hxddbb.vo.QueryVo;
import com.hxddbb.vo.resultresponse;

import java.math.BigDecimal;
import java.util.List;

public interface lbhospitalizationservice {
    //多表查询所有
    Page<lbhospitalization> findlist(QueryVo queryVo,lbhospitalization lb);

    /**
     * 查询所有
     */
    List<lbhospitalization> findAll();

    resultresponse save(lbhospitalization lbd);//保存（Insert）

    lbhospitalization edit(Integer id);//编辑（查询）

    resultresponse update(lbhospitalization lbd);//更新

    resultresponse deleteid(Integer id);//删除



    /**
     * 根据用户id查住院信息
     */
    List<lbhospitalization> findOneByUserId(Integer id);

//    List<lbhospitalization>
}
