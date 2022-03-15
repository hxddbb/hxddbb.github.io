package com.hxddbb.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.Service.lbpatientservice;
import com.hxddbb.dao.lbdoctorMapper;
import com.hxddbb.dao.lbdrugsMapper;
import com.hxddbb.dao.lbillnessMapper;
import com.hxddbb.dao.lbpatientMapper;
import com.hxddbb.entity.lbdoctor;
import com.hxddbb.entity.lbdrugs;
import com.hxddbb.entity.lbillness;
import com.hxddbb.entity.lbpatient;
import com.hxddbb.vo.resultresponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class lbpatientserviceImpl implements lbpatientservice {

@Resource
private lbpatientMapper lbtdao;
@Resource
private lbdoctorMapper lbdoc;
@Resource
private lbillnessMapper lbie;
@Resource
private lbdrugsMapper lbdrg;


    @Override
    public Page<lbpatient> finddoctorlist(Integer pageNo, Integer pageSize,lbpatient lbt) {

        QueryWrapper<lbpatient> query = new QueryWrapper<>();

        Page<lbpatient> page=new Page<>(pageNo,pageSize);//所有的分页


        //输入查询的内容
        if(!StringUtils.isEmpty(lbt.getName())) {//条件是病人名模糊查询
               query.like(lbt.getName()!=null,"name",lbt.getName());
               return lbtdao.selectPage(page,query);
          }
        if (!StringUtils.isEmpty(lbt.getCertId())){
               query.lambda().eq(lbpatient::getCertId,lbt.getCertId());
               return lbtdao.selectPage(page,query);
        }
//        if(!StringUtils.isEmpty(id)){
//            query.lambda().eq(lbpatient::getDoctorId,id);
//            return lbt.selectPage(page,query); 在SQL中完成
//        }

        if (pageNo > 0 && pageSize > 0) {
            query.lambda().orderByAsc(lbpatient::getId);
               return lbtdao.selectlist(page,lbt);

        }

return null;
}

    @Override
    public resultresponse save(lbpatient lbd) {

        QueryWrapper<lbpatient> query = new QueryWrapper<>();

        resultresponse rs=new resultresponse();

        if (!lbd.getCertId().isEmpty()){
            query.lambda().eq(lbpatient::getCertId,lbd.getCertId());
        }
          lbpatient pdsfz= lbtdao.selectOne(query);
        if (pdsfz!=null){
            rs.setCode("301");
            rs.setMessage("该病人信息已经存在！");
        }
        else {
            lbtdao.insert(lbd);
            rs.setCode("302");
            rs.setMessage("病人信息添加成功!");
        }
        return rs;
    }

    @Override
    public lbpatient edit(Integer id) {
        return lbtdao.selectById(id);
    }

    @Override
    public resultresponse update(lbpatient lbd) {
        resultresponse rs=new resultresponse();
        lbtdao.updateById(lbd);
        rs.setCode("302");
        rs.setMessage("病人信息修改成功！");
        return rs;
    }

    @Override
    public int deleteDoctor(Integer id) {
        return lbtdao.deleteById(id);
    }

    @Override//这个方法用于预约表多查方法中，因为多查病人表是左连接，重新按主表查
    public List<lbpatient> findAll() {
        return lbtdao.selectall();
    }

    @Override
    public lbpatient changeuserId(Integer id) {
        return lbtdao.selectpatient(id);
    }


                     //病人搜索信息，医生，药，疾病等
    @Override
    public Map<String, List> findInfo(String type, String name) {
        Map<String,List> map = new HashMap<>();
        List list = null;
        switch (type){
            case "illness":
                list = getIllness(name);
                map.put(type,list);
                break;
            case "doctor":
                list = getDoctors(name);
                map.put(type, list);
                break;
            case "drugs":
                list = getDrugs(name);
                map.put(type, list);
                break;
            default:
                break;
        }
        return map;
    }
    private List<lbillness> getIllness(String name) {
        QueryWrapper<lbillness> query = new QueryWrapper<>();
        if(!StringUtils.isEmpty(name)) {
            query.lambda().eq(lbillness::getName,name);
        }
        return lbie.selectList(query);
    }

    private List<lbdoctor> getDoctors(String name) {
        QueryWrapper<lbdoctor> query = new QueryWrapper<>();
        if(!StringUtils.isEmpty(name)) {
            query.lambda().eq(lbdoctor::getName,name);
        }
        return lbdoc.selectList(query);
    }

    private List<lbdrugs> getDrugs(String name) {
        QueryWrapper<lbdrugs> query = new QueryWrapper<>();
        if(!StringUtils.isEmpty(name)) {
            query.lambda().eq(lbdrugs::getName,name);
        }
        return lbdrg.selectList(query);
    }
}
