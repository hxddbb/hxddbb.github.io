package com.hxddbb.Service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.Service.lbuserservice;
import com.hxddbb.dao.lbdoctorMapper;
import com.hxddbb.dao.lbpatientMapper;
import com.hxddbb.dao.lbuserMapper;
import com.hxddbb.entity.lbdoctor;
import com.hxddbb.entity.lbpatient;
import com.hxddbb.entity.lbuser;
import com.hxddbb.vo.Activeueser;
import com.hxddbb.vo.resultresponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Transactional
@Service
public class lbuserserviceImpl implements lbuserservice {
    @Resource
    private lbuserMapper lbusermapper;
    @Resource
    private lbdoctorMapper lbdocdao;
    @Resource
    private lbpatientMapper lbpatientdao;
    @Override
    public resultresponse check(lbuser user, HttpSession session) {
        resultresponse rs=new resultresponse();
        lbuser uname=lbusermapper.selectByusername(user.getUsername());
      if(uname==null){
          rs.setCode("101");//用户不存在
          rs.setMessage("用户不存在");
      }else{
          if(uname.getPassword().equals(user.getPassword())){
              rs.setCode("102");
              rs.setMessage(String.valueOf(uname.getRole()));//绑定登录角色

              session.setAttribute("user",uname);

          }else{rs.setCode("103");
                rs.setMessage("用户名或密码错误");}//用户密码错误
      }
        return rs;
    }

    @Override
    public resultresponse regist(Activeueser activeuser) {
        resultresponse rs2=new resultresponse();
        //查询用户
        lbuser uname2=lbusermapper.selectByusername(activeuser.getUsername());

        //查询医生
        lbdoctor lbdoc=lbdocdao.selectByPrimaryKey(activeuser.getSfzid());
        //查询病人
        lbpatient lbpt=lbpatientdao.selectByPrimaryKey(activeuser.getSfzid());


        if (uname2!=null){
            rs2.setCode("201");
            rs2.setMessage("用户已经存在");
        }else if (uname2==null && activeuser.getSfzid().isEmpty()){
//            uname2.setUsername(activeuser.getUsername());//管理员不需要id，自动递增，判断role=1为管理员
//            uname2.setPassword(activeuser.getPassword());
            uname2=new lbuser();//修改对象需要实例化
            uname2.setRole(1);//1代表数据库中的管理员用户
            uname2.setUsername(activeuser.getUsername());
            uname2.setPassword(activeuser.getPassword());//修改对象的参数为用户输入传入的参数
            lbusermapper.insert(uname2);
            rs2.setCode("202");
            rs2.setMessage("管理员注册成功！");


        }else if (lbdoc!=null){ //如果查询有医生，执行医生用户注册，用户状态2表示医生
            if (lbdoc.getUserId()==null){//严谨:再次判断医生的id为空再进行注册
            uname2=new lbuser();
            uname2.setRole(2);
            uname2.setUsername(activeuser.getUsername());
            uname2.setPassword(activeuser.getPassword());//修改对象的参数为用户输入传入的参数
            lbusermapper.insert(uname2);
            //更新医生基本信息
            rs2.setCode("203");
            rs2.setMessage("医生用户注册成功！");
            lbdoc.setUserId(lbusermapper.selectByusername(activeuser.getUsername()).getId());
            lbdocdao.updatadoctor(lbdoc);//注册医生用户，同时把注册的id更新到医生表当中的userid字段[独立设计的接口]
            }else{
                rs2.setCode("205");//反之，就被占用
                rs2.setMessage("医生用户被占用！");
            }

        }else if (lbpt!=null){//如果查询有病人，执行病人用户注册，用户状态3表示病人
            if (lbpt.getUserId()==null){
            uname2=new lbuser();
            uname2.setRole(3);
            uname2.setUsername(activeuser.getUsername());
            uname2.setPassword(activeuser.getPassword());//修改对象的参数为用户输入传入的参数
            lbusermapper.insert(uname2);//用接口操作数据库插入数据
            rs2.setCode("204");
            rs2.setMessage("病人用户注册成功！");
            lbpt.setUserId(lbusermapper.selectByusername(activeuser.getUsername()).getId());//获取用户id
            lbpatientdao.updatauser(lbpt);//这里独立设计的一个更新接口，识别是病人用户注册
                // 根据病人的身份证条件，更新病人表的userid为用户表的id
                //因为用户表没有和预约表所对接，所以需要先和病人表对接，更新userid找到病人表，病人表再和预约表对接
            }else{
                rs2.setCode("205");//反之，就被占用
                rs2.setMessage("病人用户被占用！");
            }

        }else {
            rs2.setCode("106");
            rs2.setMessage("你当前还不是医生或者患者！");
        }
        return rs2;
    }

    @Override
    public Page<lbuser> finduser(Integer pageNo, Integer pageSize, String username) {
        Page<lbuser>page=new Page<>(pageNo,pageSize);
        QueryWrapper<lbuser>query=new QueryWrapper<>();
        if (!StringUtils.isEmpty(username)){
            query.lambda().like(lbuser::getUsername,username);
        } query.lambda().eq(lbuser::getRole,"1");
          if (pageNo>0 && pageSize>0){
              query.lambda().orderByDesc(lbuser::getId);
              return  lbusermapper.selectPage(page,query);
          }
        return null;
    }

    @Override
    public resultresponse save(lbuser lu) {
        resultresponse rs=new resultresponse();
        QueryWrapper<lbuser>query=new QueryWrapper<>();
        if (!StringUtils.isEmpty(lu.getUsername())){
            query.lambda().eq(lbuser::getUsername,lu.getUsername());

        }  query.lambda().eq(lbuser::getRole,1);
           lbuser pdname=lbusermapper.selectOne(query);
        if (pdname!=null){
            rs.setCode("301");
            rs.setMessage("用户已经存在");
        }else {
            lu.setRole(1);//能见到管理员的后台，身份必定是管理员，所以直接改状态码为1再插入数据库
            // 因为在表单上没有添加状态码的这一栏，所以状态码在对象里就是null了
            lbusermapper.insert(lu);
            rs.setCode("302");
            rs.setMessage("用户添加成功");
        }
        return rs;
    }

    @Override
    public lbuser edit(Integer id) {
        return lbusermapper.selectById(id);
    }

    @Override
    public resultresponse update(lbuser lu) {
        resultresponse rs=new resultresponse();
        lbusermapper.updateById(lu);
        rs.setCode("302");
        rs.setMessage("更新成功");
        return rs;
    }

    @Override
    public resultresponse deleteuser(Integer id) {
        resultresponse rs=new resultresponse();
        int nums=lbusermapper.deleteById(id);
        if (nums>0){
            rs.setCode("401");
            rs.setMessage("删除成功");
        }
        rs.setCode("402");
        rs.setMessage("删除失败");
        return rs;
    }


}





