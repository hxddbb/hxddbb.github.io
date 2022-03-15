package com.hxddbb.Service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.Service.lbmedicalhistoryservice;
import com.hxddbb.dao.lbmedicalhistoryMapper;
import com.hxddbb.entity.lbmedicalhistory;
import com.hxddbb.vo.resultresponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class lbmedicalhistoryserviceImpl implements lbmedicalhistoryservice {
    @Resource
    private lbmedicalhistoryMapper lbmedmapper;
    @Override
    public Page<lbmedicalhistory> findlist(long pageNo, long pageSize, lbmedicalhistory lmed) {
        Page<lbmedicalhistory>page=new Page<>(pageNo,pageSize);
        return lbmedmapper.selectlist(page,lmed);
    }

    @Override
    public resultresponse save(lbmedicalhistory lmed) {
        resultresponse rs=new resultresponse();
        lbmedmapper.insert(lmed);
        rs.setCode("302");
        rs.setMessage("保存成功");
        return rs;
    }

    @Override
    public lbmedicalhistory edit(Integer id) {
        return lbmedmapper.selectById(id);
    }

    @Override
    public resultresponse update(lbmedicalhistory lmed) {
        resultresponse rs=new resultresponse();
        lbmedmapper.updateById(lmed);
        rs.setCode("302");
        rs.setMessage("更新成功");
        return rs;
    }

    @Override
    public resultresponse del(Integer id) {
        resultresponse rs=new resultresponse();
         int nums=lbmedmapper.deleteById(id);
         if (nums>0){
             rs.setCode("401");
             rs.setMessage("删除成功");
         }else{
             rs.setCode("402");
             rs.setMessage("删除失败");
         }
        return rs;
    }
}
