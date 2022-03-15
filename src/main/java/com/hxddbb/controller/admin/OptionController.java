package com.hxddbb.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.Service.lboptionservice;
import com.hxddbb.entity.lboption;
import com.hxddbb.vo.resultresponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("admin/option")
public class OptionController {
    @Resource
    private lboptionservice lbo;

    @RequestMapping("/manage")
    public String manage(@RequestParam(required = false, defaultValue = "1") Integer pageNo,
                         @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                         @RequestParam(required = false) String name,
                         @RequestParam(required = false) String type,
                         Model model){
      Page<lboption>page=lbo.findlist(pageNo,pageSize,name,type);
      model.addAttribute("page",page);
      model.addAttribute("pageNo",pageNo);
      model.addAttribute("pageSize",pageSize);
      model.addAttribute("name",name);
      model.addAttribute("type",type);
      model.addAttribute("path","/admin/option/manage");
      return"admin/1/optionManage";
    }
    @RequestMapping("/")
     public String displayform(Model model,lboption lb){
     model.addAttribute("option",lb);
     return "admin/1/optionForm";
    }

    @GetMapping("/{id}")
    public String editform(Model model,@PathVariable Integer id){
    model.addAttribute("option",lbo.edit(id));
    return "admin/1/optionForm";
    }

    @PostMapping("/")
    @ResponseBody
    public resultresponse save(Model model,@RequestBody  lboption lb){
    return   lbo.save(lb);
    }

    @PutMapping("/")
    @ResponseBody
    public resultresponse update(Model model,@RequestBody  lboption lb){
    return   lbo.update(lb);
    }
    @ResponseBody
    @DeleteMapping("/{id}")
    public int del(@PathVariable Integer id){
    int reslut= lbo.del(id);

    return reslut;
    }
}
