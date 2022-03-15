package com.hxddbb.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.Service.lbdrugservice;
import com.hxddbb.entity.lbdrugs;
import com.hxddbb.vo.resultresponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lxx
 * @version 1.0.0
 * @ClassName PatientController.java
 * @Description 药品管理控制器
 * @createTime 2020年03月28日 13:48:00
 */
@Controller
@RequestMapping("/admin/drugs")
public class DrugsController {
    @Resource
    private lbdrugservice lbdservice;

    @RequestMapping("/manage")
    public String manage(@RequestParam(required = false, defaultValue = "1") Integer pageNo,
                         @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                         @RequestParam(required = false) String name,
                         @RequestParam(required = false) Integer type,
                         Model model) {
        //分页查询
        Page<lbdrugs> page = lbdservice.finddoctorlist(pageNo,pageSize,name,type);
        model.addAttribute("page",page);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("name",name);
        model.addAttribute("type",type);
        model.addAttribute("path","/admin/drugs/manage");
        return "admin/1/drugsManage";
    }
    //添加显示表单
    @RequestMapping("/")
    public String drugsform( lbdrugs lbdrug,Model model){
         model.addAttribute("drugs",lbdrug);
         return "admin/1/drugsForm";
    }
    //增
    @PostMapping("/")
    @ResponseBody
    public resultresponse saveform(@RequestBody lbdrugs lbdrug,Model model){
        return lbdservice.save(lbdrug);
    }
    //（查）编辑显示表单，会根据主键显示之前未修改的信息
    @GetMapping("/{id}")
    public String drugseditform(Model model,@PathVariable  Integer id){
          model.addAttribute("drugs",lbdservice.edit(id));
          return "admin/1/drugsForm";
    }
 //改
    @PutMapping("/")
    @ResponseBody
    public resultresponse updatedrugs(@RequestBody lbdrugs lbdrug, Model model){
        return lbdservice.update(lbdrug);
    }
    //删
@DeleteMapping("/{id}")
 @ResponseBody
    public resultresponse del(@PathVariable Integer id){
       int nums=lbdservice.deleteDoctor(id);
       resultresponse rs=new resultresponse();
       if (nums>0){
           rs.setCode("401");
           rs.setMessage("删除成功");
       }else {
           rs.setCode("402");
           rs.setMessage("删除失败");
       }
        return rs;
}
}
