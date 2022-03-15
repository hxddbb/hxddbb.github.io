package com.hxddbb.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.entity.lbdoctor;
import com.hxddbb.vo.resultresponse;

import java.util.List;

public interface Lbdoctorservice {

    Page<lbdoctor> finddoctorlist(Integer  pageNo, Integer pageSize,String name,String certId);// 查询

    resultresponse save(lbdoctor lbd);//保存（Insert）

    lbdoctor edit(Integer id);//编辑（查询）

    resultresponse update(lbdoctor lbd);//更新

    int deleteDoctor(Integer id);//删除

    List<lbdoctor>findlist();

    List<lbdoctor>finddepartment(String deptartment);


    lbdoctor finduserid(Integer id);//根据医生userid查询
}
