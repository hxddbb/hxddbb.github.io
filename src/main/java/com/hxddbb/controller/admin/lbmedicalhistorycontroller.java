package com.hxddbb.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.Service.Lbdoctorservice;
import com.hxddbb.Service.lbmedicalhistoryservice;
import com.hxddbb.Service.lbpatientservice;
import com.hxddbb.entity.lbdoctor;
import com.hxddbb.entity.lbmedicalhistory;
import com.hxddbb.entity.lbpatient;
import com.hxddbb.vo.resultresponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/admin/medicalhistory")
public class lbmedicalhistorycontroller {
    @Resource
    private lbmedicalhistoryservice lbmeds;
    @Autowired
    private lbpatientservice lbpat;
    @Autowired
    private Lbdoctorservice lbdo;
    @RequestMapping("/manage")
    public String manage(@RequestParam (required = false,defaultValue = "1")long pageNo,
                         @RequestParam(required = false,defaultValue = "5")long pageSize,
                         lbmedicalhistory lmed, Model model){
         Page<lbmedicalhistory> page=lbmeds.findlist(pageNo,pageSize,lmed);
        model.addAttribute("page",page);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("patientName",lmed.getPatientName());
        model.addAttribute("doctorName",lmed.getDoctorName());
        model.addAttribute("path","/admin/medicalhistory/manage");
        return "admin/1/medicalHistoryManage";
    }
    //单表主查询的所有病人和所有的医生绑定到前端对象
    // 这样的写法让两个变量很解耦，不用再某一个请求中使用，可以直接当作前端中的对象使用
    @ModelAttribute("doctors")
    public List<lbdoctor> getDoctors() {
        return lbdo.findlist();
    }
    @ModelAttribute("patients")
    public List<lbpatient> getPatients() {
        return lbpat.findAll();
    }
    /**
     * 新增
     */
    @RequestMapping("/")
    public String addForm(lbmedicalhistory lmed,Model model) {
        model.addAttribute("medicalhistory",lmed);
        return "admin/1/medicalHistoryForm";
    }

    /**
     * 编辑
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("medicalhistory",lbmeds.edit(id));
        return "admin/1/medicalHistoryForm";
    }

    /**
     * 异步插入记录
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public resultresponse insert(@RequestBody lbmedicalhistory lmed) {
        return lbmeds.save(lmed);
    }

    /**
     * 异步更新记录
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public resultresponse update(@RequestBody lbmedicalhistory lmed) {
        return lbmeds.update(lmed);
    }

    /**
     * 异步删除
     */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public resultresponse delete(@PathVariable Integer id){
        return lbmeds.del(id);
    }
}
