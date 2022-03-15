package com.hxddbb.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class Indexcontroller {

    @RequestMapping("/index")
    public String index(){
        return "admin/1/index";
    }
}
