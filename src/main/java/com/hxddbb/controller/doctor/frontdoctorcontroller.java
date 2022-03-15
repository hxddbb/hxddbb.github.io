package com.hxddbb.controller.doctor;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.Service.*;
import com.hxddbb.entity.lbappointment;
import com.hxddbb.entity.lbdoctor;
import com.hxddbb.entity.lbuser;
import com.hxddbb.vo.QueryVo;
import com.hxddbb.vo.resultresponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/doctor")
public class frontdoctorcontroller {
     @Resource
     private Lbdoctorservice lbdoctorservice;
     @Autowired
     private lbpatientservice lbservice;
     @Autowired
     private appointmentservice appservice;
     @Autowired
     private lboptionservice optionservice;
     @Autowired
     private lbdrugservice drugservice;
     @Autowired
     private lbseekservice seekvice;

     @RequestMapping("/index")
     public String index(Model model, QueryVo queryVo, HttpSession session){
          lbuser  user= (lbuser) session.getAttribute("user");
          queryVo.setUserId(user.getId());
//          lbdoctor lbdo=lbdoctorservice.finduserid(user.getId());
          Page<lbappointment> page=appservice.findDoctor(queryVo);
          model.addAttribute("page",page);
//          model.addAttribute("doctor",lbdo);
          model.addAttribute("path","/doctor/index");
          model.addAttribute("pageNo", queryVo.getPageNo());
         return "doctor/index";
     }

     @RequestMapping("/seek/{id}/{appointmentId}")
     public String seek(@PathVariable("id")Integer patientId,Model model,
                        @PathVariable("appointmentId") Integer appointmentId){
         //获取患者信息
           model.addAttribute("patient",lbservice.edit(patientId));
         //获取检查项目列表
           model.addAttribute("options",optionservice.findall());
         //药品列表
           model.addAttribute("drugs", drugservice.findall());
           model.addAttribute("appointmentId",appointmentId);
         return "doctor/seek";
     }
    /**
     * 就诊
     */
    @ResponseBody
    @RequestMapping("/seekInfo")
    public resultresponse seekInfo(@RequestBody Map map, HttpSession session) {
        return seekvice.save(map,session);
    }

    /**
     * 开药
     */
    @ResponseBody
    @RequestMapping("/drug")
    public resultresponse drug(@RequestBody Map map,HttpSession session) {
        return seekvice.update(map,session);
    }

    //按照部门查询出医生，预约表单中选择部门，对应的医生就出来了
    @ResponseBody
    @RequestMapping("/getList/{department}")
    public List<lbdoctor> getList(@PathVariable String department){

        return lbdoctorservice.finddepartment(department);
    }

}
