package com.hxddbb.controller.home;

import com.hxddbb.Service.lbuserservice;
import com.hxddbb.entity.lbuser;
import com.hxddbb.vo.Activeueser;
import com.hxddbb.vo.resultresponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/home/user")
public class logincontroller {
    @Resource
    private lbuserservice lbsve;



    //登录页面视图转发
    @RequestMapping("/loginregistpage")
    public String loginregist() {
        return "home/login&regist";
    }

@RequestMapping(value = "/login")
@ResponseBody
    public resultresponse login(@RequestBody  lbuser user, HttpSession session){
//    resultresponse rs=lbsve.check(user,session);
//    if(rs.getCode().equals("102")){//注意，登录成功的状态码不能错了，否则把自己也拦在外面
//
//        session.setAttribute("user",user);
//    }
//    return rs;
      return lbsve.check(user,session);
}


@RequestMapping("/regist")
@ResponseBody
public resultresponse regist(@RequestBody Activeueser activeueser){
       resultresponse rs2=lbsve.regist(activeueser);
        return rs2;
}

    /**
     * 安全退出
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // 清除sessin
        session.invalidate();
        return "redirect:/home/user/loginregistpage";
        //return new Modelandview("redirect:/home/user/login");
    }
}
