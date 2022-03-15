package com.hxddbb.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.Service.lbillnesservice;
import com.hxddbb.entity.lbillness;
import com.hxddbb.vo.resultresponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("admin/illness")
public class illnesscontroller {
    @Resource
    private lbillnesservice lbi;
    @RequestMapping("/manage")
    public String manage(@RequestParam(required = false, defaultValue = "1") Integer pageNo,
                         @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                         @RequestParam(required = false) String name,
                         @RequestParam(required = false) String type,
                         Model model){
        //分页查询
        Page<lbillness> page = lbi.findlist(pageNo,pageSize,name,type);
        model.addAttribute("page",page);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("name",name);
        model.addAttribute("type",type);
        model.addAttribute("path","/admin/illness/manage");
        return "admin/1/illnessManage";


    }  @RequestMapping("/")
    public String displayform(Model model, lbillness lb){
        model.addAttribute("illness",lb);
        return "admin/1/illnessForm";
    }

    @GetMapping("/{id}")
    public String editform(Model model,@PathVariable Integer id){
        model.addAttribute("illness",lbi.edit(id));
        return "admin/1/illnessForm";
    }

    @PostMapping("/")
    @ResponseBody
    public resultresponse save(Model model, @RequestBody  lbillness lb){
        return  lbi.save(lb);
    }

    @PutMapping("/")
    @ResponseBody
    public resultresponse update(Model model,@RequestBody  lbillness lb){
        return   lbi.update(lb);
    }
    @ResponseBody
    @DeleteMapping("/{id}")
    public int del(@PathVariable Integer id){
        int reslut= lbi.del(id);
        if (reslut>0);
        return reslut;
    }

}
