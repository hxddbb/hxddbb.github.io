package com.hxddbb.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.Service.lbdrugservice;
import com.hxddbb.dao.lbdrugsMapper;
import com.hxddbb.entity.lbdrugs;
import com.hxddbb.vo.resultresponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class lbdrugserviceImpl implements lbdrugservice {

    @Resource
    private lbdrugsMapper lbdrug;

    @Override
    public Page<lbdrugs> finddoctorlist(Integer pageNo, Integer pageSize, String name, Integer type) {
        QueryWrapper<lbdrugs> query = new QueryWrapper<>();

        Page<lbdrugs> page=new Page<>(pageNo,pageSize);

        if (!StringUtils.isEmpty(name)){
            query.like(name!=null,"name",name);

        }
        if (!StringUtils.isEmpty(type)){
            query.lambda().eq(lbdrugs::getType,type);

        }
        if (pageNo > 0 && pageSize > 0){
            query.lambda().orderByAsc(lbdrugs::getId);//注意这里一直要加条件！！不然上面两个方法值后不返回，执行此if

            return  lbdrug.selectPage(page,query);
        }

        return null;
    }
//增加
    @Override
    public resultresponse save(lbdrugs lbd) {
        QueryWrapper<lbdrugs> query = new QueryWrapper<>();
        resultresponse rs=new resultresponse();
        if (!StringUtils.isEmpty(lbd.getName())){
            query.lambda().eq(lbdrugs::getName,lbd.getName());
        }
            lbdrugs pdname=lbdrug.selectOne(query);
        if (pdname!=null){
            rs.setCode("301");
            rs.setMessage("该药品已经存在，无需再次添加");
        }else {
            lbdrug.insert(lbd);
            rs.setCode("302");
            rs.setMessage("添加药品成功！");
        }

        return rs;
    }
//查询
    @Override
    public lbdrugs edit(Integer id) {
        resultresponse rs=new resultresponse();
        return  lbdrug.selectById(id);

    }

    @Override
    public resultresponse update(lbdrugs lbd) {
        resultresponse rs=new resultresponse();
        lbdrug.updateById(lbd);
        rs.setCode("302");
        rs.setMessage("药品信息已更新！");
        return rs;
    }

    @Override
    public int deleteDoctor(Integer id) {
        return lbdrug.deleteById(id);
    }

    @Override
    public List<lbdrugs> findall() {
        return lbdrug.selectall();
    }
}
