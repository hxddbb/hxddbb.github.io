package com.hxddbb.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.entity.lbuser;
import com.hxddbb.vo.Activeueser;
import com.hxddbb.vo.QueryVo;
import com.hxddbb.vo.resultresponse;

import javax.servlet.http.HttpSession;

public interface lbuserservice {
//校验登录
    resultresponse check(lbuser user, HttpSession session);
//注册
    resultresponse regist(Activeueser activeuser);
    
    //查询所有
    Page<lbuser> finduser(Integer pageNo, Integer pageSize,String username);

    resultresponse save(lbuser lu);//保存（Insert）

    lbuser edit(Integer id);//编辑（查询）

    resultresponse update(lbuser lu);//更新

    resultresponse deleteuser(Integer id);//删除
}
