package com.hxddbb.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.entity.lbappointment;
import com.hxddbb.entity.lbpatient;
import com.hxddbb.vo.resultresponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface lbpatientservice {

    Page<lbpatient> finddoctorlist(Integer  pageNo, Integer pageSize,lbpatient lbt);
    
    resultresponse save(lbpatient lbd);//保存（Insert）
    
    lbpatient edit(Integer id);//编辑（查询）
    
    resultresponse update(lbpatient lbd);//更新
    
    int deleteDoctor(Integer id);//删除
//查询所有病人[非多表查询，select*]
    List<lbpatient> findAll();

 //将用户登录的id换成病人表的userid，再用userid为条件查询
    lbpatient changeuserId(Integer id);


    // 查询信息（医生、疾病、药品）

    Map<String,List> findInfo(String type, String name);
}
