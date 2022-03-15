package com.hxddbb.controller.patient;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.Service.appointmentservice;
import com.hxddbb.Service.lbhospitalizationservice;
import com.hxddbb.Service.lbmedicalhistoryservice;
import com.hxddbb.Service.lbpatientservice;
import com.hxddbb.common.Global;
import com.hxddbb.common.PDFUtils;
import com.hxddbb.entity.lbappointment;
import com.hxddbb.entity.lbmedicalhistory;
import com.hxddbb.entity.lbpatient;
import com.hxddbb.entity.lbuser;
import com.hxddbb.vo.QueryVo;
import com.hxddbb.vo.resultresponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/patient")
public class Frontpatientcontroller {
//    @Value("${filepath.appointpdf}")
//    private String appointPath;

    @Resource
    private appointmentservice appserv;
    @Resource
    private lbpatientservice lbpt;
    @Resource
    private lbmedicalhistoryservice lbmed;
    @Resource
    private lbhospitalizationservice lbhosp;

    /**
     * 患者主页面，显示当前预约记录的患者[多表联查，条件是userid，预约表先和病人表连接找到所有预约病人
     * 用户登录之后，再把上面多表查询【病人表+预约表】的userid字段修改为请求域用户的id，找到该用户所对应的预约信息
     */
    @RequestMapping("/index")
    public String index(HttpSession session, QueryVo queryVo, Model model) {
        lbuser use = (lbuser) session.getAttribute("user");
        queryVo.setUserId(use.getId());
        Page<lbappointment> page = appserv.findlist(queryVo);
        model.addAttribute("page", page);
        model.addAttribute("pageNo", queryVo.getPageNo());
        model.addAttribute("path", "/patient/index");
        return "patient/appointmentHistory";
    }

    //用户看见预约记录之后，如果点击预约，展示预约所填的类容，既然是当前用户预约，预约病人就不用填了
// 所以要根据用户登录的id，和病人表的userid做一个连接，这样谁登录，预约人默认就是他自己
    @GetMapping("/appointment")
    public String displayform(HttpSession session, Model model) {
        lbuser user = (lbuser) session.getAttribute("user");
        lbpatient patient = lbpt.changeuserId(user.getId());
//     patient.setUserId(user.getId());
        //将患者的信息放到model
        model.addAttribute("patient", patient);
        return "patient/appointmentForm";
    }

    @PostMapping("/appointment")
    @ResponseBody
    public resultresponse save(@RequestBody lbappointment lbap) {
        lbap.setStatus(Global.SEEK_CODE_NONE);
        appserv.insertReturnId(lbap);//把用户填的信息。添加到预约表
        //将预约的信息更新到病人表，插入对象返回主键，在mybatisplus里面的insert方法执行完成时已经把主键ID赋值回来给实体ID了。
        //// 直接在controller层取entity.getId()就行。
        lbpatient patient = new lbpatient();//实例化要更新的数据
        patient.setId(lbap.getPatientId());//根据id修改，这里病人重新实例化，需要给id赋值
        patient.setAppointmentId(lbap.getId());//包括预约表的id也要更新到病人表
        lbpt.update(patient);
        return new resultresponse(Global.SAVE_CODE_SUCCESS, Global.SAVE_APPOINTMENT_SUCCESS);
    }

    /**
     * 生成挂号单
     */
    @ResponseBody
    @RequestMapping(value = "/appointment/createPDF", method = RequestMethod.POST)
    public resultresponse createPDF(HttpSession session) {
        //获取当前用户最近一次的预约记录
        lbuser user = (lbuser) session.getAttribute("user");
        lbpatient patient = lbpt.changeuserId(user.getId());
        lbappointment appointment = appserv.edit(patient.getAppointmentId());
        return new resultresponse(Global.APPOINTMENT_CODE_SUCCESS, PDFUtils.createAppointment(appointment, "D:/"));
    }

    /**
     * 查询
     */
    @RequestMapping("/search")
    public String search() {
        return "patient/search";
    }

    /**
     * 查询信息
     */
    @ResponseBody
    @RequestMapping("/searchInfo")
    public Map<String, List> searchInfo(String type, String name) {
        return lbpt.findInfo(type, name);
    }

    /**
     * 查看既往病史
     */
    @RequestMapping("/medicalHistory")
    public String medicalHistory(@RequestParam(required = false, defaultValue = "1") long pageNo,
                                 @RequestParam(required = false, defaultValue = "10") long pageSize,
                                 lbmedicalhistory lbm, HttpSession session, Model model) {
        lbuser user = (lbuser) session.getAttribute("user");
        lbm.setUserId(user.getId());
        Page<lbmedicalhistory> page = lbmed.findlist(pageNo, pageSize, lbm);
        model.addAttribute("page", page);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("path", "/patient/medicalHistory");
        return "patient/medicalHistory";
    }

    /**
     * 查询所有住院记录
     */
    @RequestMapping("/hospitalization")
    public String hospitalization(HttpSession session, Model model) {
        lbuser user = (lbuser) session.getAttribute("user");
        model.addAttribute("hospitalization",lbhosp.findOneByUserId(user.getId()));
        return "patient/hospitalization";
    }
}
