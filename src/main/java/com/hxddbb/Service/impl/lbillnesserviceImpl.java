package com.hxddbb.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.Service.lbillnesservice;
import com.hxddbb.dao.lbillnessMapper;
import com.hxddbb.entity.lbillness;
import com.hxddbb.vo.resultresponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class lbillnesserviceImpl implements lbillnesservice {
    @Resource
    private lbillnessMapper lbi;

    @Override
    public Page<lbillness> findlist(Integer pageNo, Integer pageSize, String name, String text) {
       QueryWrapper<lbillness> query=new QueryWrapper<>();//条件不能做全局变量，需求不一样，条件不一样
       Page<lbillness>page=new Page<>(pageNo,pageSize);
       if (!StringUtils.isEmpty(name)){
           query.lambda().like(lbillness::getName,name);

       }
        if (pageNo>0&&pageSize>0){
           query.lambda().orderByAsc(lbillness::getId);
           return lbi.selectPage(page,query);
        }

       return null;
    }

    @Override
    public resultresponse save(lbillness lbnes) {
        QueryWrapper<lbillness> query=new QueryWrapper<>();
        resultresponse rs=new resultresponse();
        if (!StringUtils.isEmpty(lbnes.getName())){
            query.lambda().eq(lbillness::getName,lbnes.getName());
        } lbillness illname=lbi.selectOne(query);
        if (illname!=null){
            rs.setCode("301");
            rs.setMessage("该病已经存在");
        }else {
            lbi.insert(lbnes);
            rs.setCode("302");
            rs.setMessage("疾病名称已添加");
        }
        return rs;
    }

    @Override
    public lbillness edit(Integer id) {
        return lbi.selectById(id);
    }

    @Override
    public resultresponse update(lbillness lbnes) {
        resultresponse rs=new resultresponse();
        lbi.updateById(lbnes);
        rs.setCode("302");
        rs.setMessage("疾病信息更新成功！");
        return rs;

    }

    @Override
    public int del(Integer id) {
        return lbi.deleteById(id);
    }
}
