package com.hxddbb.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.Service.lbhospitalizationservice;
import com.hxddbb.Service.lbpatientservice;
import com.hxddbb.entity.lbhospitalization;
import com.hxddbb.entity.lbpatient;
import com.hxddbb.vo.QueryVo;
import com.hxddbb.vo.resultresponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/admin/hospitalization")
public class lbhospitalizationcontroller {
    @Resource
    private lbhospitalizationservice lbhosp;
    @Autowired
    private lbpatientservice lbPatientService;

    @ModelAttribute("patients")
    public List<lbpatient> getPatients(){
        return  lbPatientService.findAll();
    }

    @RequestMapping("/manage")
    public String manage(QueryVo queryVo, Model model,lbhospitalization lb){
        Page<lbhospitalization> page =lbhosp.findlist(queryVo,lb);
        model.addAttribute("page",page);
        model.addAttribute("pageNo",queryVo.getPageNo());
        model.addAttribute("patientName",lb.getPatientName());
        model.addAttribute("intime",lb.getIntime());
        model.addAttribute("path","/admin/hospitalization/manage");
        return "admin/1/hospitalizationManage";
    }

    /**
     * 新增
     */
    @RequestMapping("/")
    public String addForm(lbhospitalization lb,Model model) {
        model.addAttribute("hospitalization",lb);
        return "admin/1/hospitalizationForm";
    }

    /**
     * 编辑
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("hospitalization",lbhosp.edit(id));
        return "admin/1/hospitalizationForm";
    }

    /**
     * 异步插入记录
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public resultresponse insert(@RequestBody lbhospitalization lb) {
        return lbhosp.save(lb);
    }

    /**
     * 异步更新记录
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public resultresponse update(@RequestBody lbhospitalization lb) {
        return lbhosp.update(lb);
    }

    /**
     * 异步删除`
     */
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public resultresponse delete(@PathVariable Integer id){
        return lbhosp.deleteid(id);
    }
}
