package com.hxddbb.Service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.Service.Lbdoctorservice;
import com.hxddbb.dao.lbdoctorMapper;
import com.hxddbb.entity.lbdoctor;
import com.hxddbb.vo.resultresponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service

public class LbdoctorserviceImpl implements Lbdoctorservice {

    @Resource
    private lbdoctorMapper ldoc;



    @Override//分页
    public Page<lbdoctor> finddoctorlist(Integer pageNo, Integer pageSize,String name,String certId) {
//        lbdoctor lb=new lbdoctor();

        Page<lbdoctor> page=new Page<>(pageNo,pageSize);//所有的分页
        QueryWrapper<lbdoctor> query = new QueryWrapper<>();//实例化条件查询

             //输入查询的内容
         if (!StringUtils.isEmpty(name)) {//条件是医生名查询
            query.lambda().like(lbdoctor::getName,name);

            }
         if (!StringUtils.isEmpty(certId)){//条件是身份证查询
            query.lambda().eq(lbdoctor::getCertId,certId);

            }
        else {//这里是显示所有的医生列表，所以条件为空
            //注意这里一直要加条件！！不然上面两个方法值后不返回，执行此if
             query.lambda().orderByAsc(lbdoctor::getId);
             return  ldoc.selectPage(page,query);//前面是分页，没有条件的话，后面就是null
    }
         return null;
   }

    @Override
    public resultresponse save(lbdoctor lbd) {
           QueryWrapper<lbdoctor> query = new QueryWrapper<>();//实例化条件查询
           resultresponse rs=new resultresponse();
        if (!StringUtils.isEmpty(lbd.getCertId())) {//如果用户输入的身份证不是空↓
            //不能使用模糊查询，输入类似的关键字也会显示存在，无法添加新的数据
            query.lambda().eq(lbdoctor::getCertId, lbd.getCertId());//先查询身份证是否存在
        }
             lbdoctor sfzid=ldoc.selectOne(query);
                if (sfzid != null){
                rs.setCode("301");
                rs.setMessage("该医生信息已经添加");
//                rs.setCode(Global.SAVE_CODE_ERROR);
//                rs.setMessage(Global.SAVE_MSG_ERROR);
            }
            else {
                    ldoc.insert(lbd);
                    rs.setCode("302");
                    rs.setMessage("医生信息插入成功");
                  }
          return rs;
        }
//用户点击编辑，查询出此医生的信息并显示
    @Override
    public lbdoctor edit(Integer id) {
        return ldoc.selectById(id);
    }
//当用户修改原信息提交执行修改方法
    @Override
    public resultresponse update(lbdoctor lbd) {
        resultresponse rs=new resultresponse();
        ldoc.updateById(lbd);
        rs.setCode("302");
        rs.setMessage("医生信息更新成功");
        return rs;
    }
//删除
    @Override
    public int deleteDoctor(Integer id) {
        resultresponse rs=new resultresponse();
        return  ldoc.deleteById(id);
    }

    @Override
    public List<lbdoctor> findlist() {
        return ldoc.selectlist();
    }

    @Override
    public List<lbdoctor> finddepartment(String s) {
        return ldoc.selectdepartment(s);
    }

    @Override
    public lbdoctor finduserid(Integer id) {
        return ldoc.selectuserid(id);
    }

}




