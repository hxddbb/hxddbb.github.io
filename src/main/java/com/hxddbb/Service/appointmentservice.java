package com.hxddbb.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.entity.lbappointment;
import com.hxddbb.vo.QueryVo;
import com.hxddbb.vo.resultresponse;
import org.beetl.sql.core.engine.PageQuery;

import java.util.Map;

public interface appointmentservice {
    //多表查询所有
    <Page extends IPage<lbappointment>> Page findlist(QueryVo queryVo);

    //查询医生的患者预约记录        Integer pageNO,Integer pageSize,lbappointment query

    Page<lbappointment> findDoctor(QueryVo queryVo);
    
    resultresponse save(lbappointment lbd);//保存（Insert）

    lbappointment edit(Integer id);//编辑（查询）

    resultresponse update(lbappointment lbd);//更新

    int deleteDoctor(Integer id);//删除

    /**
     * 插入返回主键
     */
    Integer insertReturnId(lbappointment appointment);

    //根据病人id查询预约记录
    lbappointment findpatient(Integer id);
}
