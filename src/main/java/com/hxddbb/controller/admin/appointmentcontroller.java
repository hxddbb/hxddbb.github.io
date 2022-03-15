package com.hxddbb.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.Service.Lbdoctorservice;
import com.hxddbb.Service.appointmentservice;
import com.hxddbb.Service.lbpatientservice;
import com.hxddbb.entity.lbappointment;
import com.hxddbb.vo.QueryVo;
import com.hxddbb.vo.resultresponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/appointment")
public class appointmentcontroller {

        @Autowired
        private lbpatientservice lbPatientService;
        @Autowired
        private appointmentservice lbAppointmentService;
        @Autowired
        private Lbdoctorservice  lbdo;

//    @ModelAttribute("doctors")
//    public List<lbdoctor> getDoctors() {
//        return lbdo.findlist();
//    }

        @RequestMapping("/manage")
        public String manage(QueryVo queryVo, Model model,lbappointment query) {
            //查询预约记录
            Page<lbappointment> page =lbAppointmentService.findlist(queryVo);
            model.addAttribute("page",page);
            model.addAttribute("pageNo",queryVo.getPageNo());
            model.addAttribute("patientName",queryVo.getPatientName());
            model.addAttribute("doctorName",queryVo.getDoctorName());
            model.addAttribute("path","/admin/appointment/manage");
            return "admin/1/appointmentManage";
        }
        //展示表单
        @RequestMapping("/")
      public String displayform(Model model,lbappointment lb){
              model.addAttribute("patientList",lbPatientService.findAll());
              model.addAttribute("doctorlist",lbdo.findlist());
              model.addAttribute("appointment",lb);
          return "admin/1/appointmentForm";
        }
//编辑展示表单
       @GetMapping("/{id}")
     public String edit(@PathVariable Integer id, Model model){
            model.addAttribute("appointment",lbAppointmentService.edit(id));
     return "admin/1/appointmentForm";
       }

       @ResponseBody
    @PostMapping("/")
    public resultresponse save(@RequestBody lbappointment lbap,Model model){
            return  lbAppointmentService.save(lbap);
       }

    @PutMapping("/")
    public resultresponse update(@RequestBody lbappointment lap,Model model){
            return lbAppointmentService.update(lap);
    }

    @DeleteMapping("/{id}")
    public int del(@PathVariable Integer id){
            return lbAppointmentService.deleteDoctor(id);
    }

}
