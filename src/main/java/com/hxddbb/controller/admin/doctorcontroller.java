package com.hxddbb.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.Service.Lbdoctorservice;
import com.hxddbb.entity.lbdoctor;
import com.hxddbb.vo.resultresponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/admin/doctor")
public class doctorcontroller {
    @Resource
    private Lbdoctorservice lbdoctorservice;
    @RequestMapping("/manage")
    public String index(  @RequestParam(required = false,defaultValue = "1")Integer pageNo,
                          @RequestParam(required = false,defaultValue = "5")Integer pageSize,
                          @RequestParam(required = false) String name,
                          @RequestParam(required = false)String certId,
                        Model model){
        Page<lbdoctor>page=lbdoctorservice.finddoctorlist(pageNo,pageSize,name,certId);
        model.addAttribute("page",page);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("cerid",certId);
        model.addAttribute("path","/admin/doctor/manage");
        return "admin/1/doctorManage";}
    //编辑，首先查询，把原信息显示上
//    @RequestMapping("/Form")
//    public String edit(lbdoctor lbd,Model model){
//        if (lbd.getId()!=null){ //判断对象为要更新的对象还是新插入的对象
//            model.addAttribute("doctor",lbdoctorservice.edit(lbd.getId()));}
//        else {model.addAttribute("doctor",lbd);}
//        return "admin/1/doctorForm";
//    }
    //显示表单，为save准备
    @RequestMapping("/")
    public String doctoraddform(lbdoctor lbd,Model model){
      model.addAttribute("doctor",lbd);
        return "admin/1/doctorForm";

    }


    //在新增页面异步保存医生信息

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable Integer id,Model model) {
        model.addAttribute("doctor",lbdoctorservice.edit(id));
        return "admin/1/doctorForm";
    }


// 修改原信息，提交
@PostMapping("/")
 @ResponseBody
    public resultresponse save(@RequestBody  lbdoctor lb){
        return lbdoctorservice.save(lb);
 }

 @PutMapping("/")
 @ResponseBody
  public resultresponse update(@RequestBody  lbdoctor lb){
        return lbdoctorservice.update(lb);
 }

    @ResponseBody
    @DeleteMapping("/{id}")
    public resultresponse del(@PathVariable Integer id){
     int rows=lbdoctorservice.deleteDoctor(id);
     resultresponse rs=new resultresponse();
     if (rows>0){
         rs.setCode("401");
         rs.setMessage("删除成功");
     }else {
         rs.setCode("402");
         rs.setMessage("删除失败");
     }
        return rs;
    }

}


