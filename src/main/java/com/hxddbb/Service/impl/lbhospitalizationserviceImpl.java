package com.hxddbb.Service.impl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.Service.lbhospitalizationservice;
import com.hxddbb.dao.lbhospitalizationMapper;
import com.hxddbb.entity.lbappointment;
import com.hxddbb.entity.lbhospitalization;
import com.hxddbb.vo.QueryVo;
import com.hxddbb.vo.resultresponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class lbhospitalizationserviceImpl implements lbhospitalizationservice {

    @Resource
    private lbhospitalizationMapper lbhospitalizationmapper;
    @Override
    public Page<lbhospitalization> findlist(QueryVo queryVo,lbhospitalization lb) {
        Page<lbhospitalization> page=new Page<>(queryVo.getPageNo(),queryVo.getPageSize());

       if (queryVo.getPageNo()>0&&queryVo.getPageSize()>0){
           return lbhospitalizationmapper.selectlist(page,lb);
       }
       return null;
    }



    @Override
    public resultresponse save(lbhospitalization lbd) {
        resultresponse rs=new resultresponse();
        lbhospitalizationmapper.insert(lbd);
        rs.setCode("302");
        rs.setMessage("保存成功");
        return rs;
    }

    @Override
    public lbhospitalization edit(Integer id) {
        return lbhospitalizationmapper.selectById(id);
    }

    @Override
    public resultresponse update(lbhospitalization lbd) {
        resultresponse rs=new resultresponse();
        lbhospitalizationmapper.updateById(lbd);
        rs.setCode("302");
        rs.setMessage("保存成功");
        return rs;
    }

    @Override
    public resultresponse deleteid(Integer id) {
        resultresponse rs=new resultresponse();
              int nums=  lbhospitalizationmapper.deleteById(id);
              if (nums>0){
                  rs.setCode("401");
                  rs.setMessage("删除成功");
              }else {
                  rs.setCode("402");
                  rs.setMessage("删除失败");
              }
        return rs;
    }





//暂时没用到这两个
@Override
public List<lbhospitalization>  findOneByUserId(Integer id) {
//    Page<lbappointment> page=new Page<>(pageNo,pageSize);
    return lbhospitalizationmapper.selectonepatient(id);
}

    @Override
    public List<lbhospitalization> findAll() {
        return lbhospitalizationmapper.selectall();
    }
}
