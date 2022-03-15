package com.hxddbb.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.Service.lbpatientservice;
import com.hxddbb.entity.lbpatient;
import com.hxddbb.vo.resultresponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/admin/patient")
@Controller
public class patientcontroller {
    @Resource
    private lbpatientservice lbPatientService;
    @RequestMapping("/manage")
    public String manage( @RequestParam(required = false,defaultValue = "1")Integer pageNo,
                          @RequestParam(required = false,defaultValue = "5")Integer pageSize,
//                          @RequestParam(required = false) String name,
//                          @RequestParam(required = false)String certId,
//                          @RequestParam(required = false)Integer doctorid,
                          lbpatient lbt,
                          Model model) {
        //查询患者的集合数据
        Page<lbpatient> page = lbPatientService.finddoctorlist(pageNo,pageSize,lbt);
        model.addAttribute("page",page);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("name",lbt.getName());
        model.addAttribute("certId",lbt.getCertId());
        model.addAttribute("path","/admin/patient/manage");
        return "admin/1/patientManage";
    }
//增加展示表单
    @RequestMapping("/")
    public String displayform(lbpatient lbpt,Model model){
        model.addAttribute("patient",lbpt);
        return "admin/1/patientForm";
    }

    //（查）编辑显示表单，会根据主键显示之前未修改的信息
    @GetMapping("/{id}")
     public String getselect(@PathVariable Integer id, Model model){
         model.addAttribute("patient",lbPatientService.edit(id));
        return "admin/1/patientForm";
    }
    //增
    @PostMapping("/")
    @ResponseBody
     public resultresponse save(@RequestBody lbpatient lbpt){

        return lbPatientService.save(lbpt);
    }

    @PutMapping("/")
    @ResponseBody
    public resultresponse updata(@RequestBody lbpatient lbpt){

        return lbPatientService.update(lbpt);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public int del(Integer id){
       int nums= lbPatientService.deleteDoctor(id);
       if (nums>0);
       return nums;
    }
}
