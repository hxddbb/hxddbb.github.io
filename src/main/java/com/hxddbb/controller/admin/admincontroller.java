package com.hxddbb.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.Service.lbuserservice;
import com.hxddbb.entity.lbuser;
import com.hxddbb.vo.resultresponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/user")
public class admincontroller {
    @Autowired
    private lbuserservice userservce;
    @RequestMapping("/manage")
    public String manage(@RequestParam(required = false, defaultValue = "1") Integer pageNo,
                         @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                         @RequestParam(required = false) String username,
                         Model model){
        Page<lbuser> page=userservce.finduser(pageNo,pageSize,username);
        model.addAttribute("page",page);
        model.addAttribute("username",username);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("path","/admin/user/manage");
        return "admin/1/adminManage";
    }

    @RequestMapping("/")
    public String displayform(Model model,lbuser user){
        model.addAttribute("admin",user);
        return "admin/1/adminForm";
    }
    @GetMapping("/{id}")
    public String editform(@PathVariable Integer id,Model model){
        model.addAttribute("admin",userservce.edit(id));
        return "admin/1/adminForm";
    }
    @PutMapping("/")
    @ResponseBody
    public resultresponse update(@RequestBody lbuser user){
        return  userservce.update(user);
    }
    @PostMapping("/")
    @ResponseBody
    public resultresponse save(@RequestBody lbuser user){
        return  userservce.save(user);
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    public resultresponse del(@PathVariable Integer id){
        return  userservce.deleteuser(id);
    }
}
