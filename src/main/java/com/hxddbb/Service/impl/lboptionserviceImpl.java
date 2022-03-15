package com.hxddbb.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.Service.lboptionservice;
import com.hxddbb.dao.lboptionMapper;
import com.hxddbb.entity.lboption;
import com.hxddbb.vo.resultresponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
@Transactional
@Service
public class lboptionserviceImpl implements lboptionservice {
    @Resource
    private lboptionMapper lbop;

    @Override
    public Page<lboption> findlist(Integer pageNo, Integer pageSize, String name, String type) {
        QueryWrapper<lboption> query=new QueryWrapper<>();
        Page<lboption>page=new Page<>(pageNo,pageSize);
        if  (!StringUtils.isEmpty(name)){
            query.lambda().like(lboption::getName,name);

        }if (!StringUtils.isEmpty(type)){
            query.lambda().eq(lboption::getType,type);

        }if (pageNo>0&&pageSize>0){
            query.lambda().orderByAsc(lboption::getId);
            return lbop.selectPage(page,query);

        }

        return null;
    }

    @Override
    public resultresponse save(lboption lbp) {
        QueryWrapper<lboption> query=new QueryWrapper<>();
        resultresponse rs=new resultresponse();
        if (!lbp.getName().isEmpty()){
            query.lambda().eq(lboption::getName,lbp.getName());
        }
            lboption pdname= lbop.selectOne(query);
        if (pdname!=null){
            rs.setCode("301");
            rs.setMessage("此科目已经存在！");
        }else {
        lbop.insert(lbp);
        rs.setCode("302");
        rs.setMessage("科目添加成功");
        }return rs;
    }

    @Override
    public lboption edit(Integer id) {
        return lbop.selectById(id);
    }

    @Override
    public resultresponse update(lboption lbp) {
        resultresponse rs=new resultresponse();
        lbop.updateById(lbp);
        rs.setCode("302");
        rs.setMessage("科目修改成功");
        return null;
    }

    @Override
    public int del(Integer id) {
        return lbop.deleteById(id);
    }

    @Override
    public List<lboption> findall() {
        return lbop.selectall();
    }
}
