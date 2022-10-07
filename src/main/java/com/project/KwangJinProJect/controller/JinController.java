package com.project.KwangJinProJect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JinController {


//    @GetMapping("/loginPage")
//    public String loginPage() {
//        return "loginPage";
//    }

    @GetMapping({"", "/"})
    public String home(){
        return "index";
    }
    @GetMapping("kwangJin/signup")
    public String signUp(){
         return "kwangJinSignUp";
    }
    @GetMapping("kwangJin/list")
    public String list(){
         return "kwangJinList";
    }
    @GetMapping("kwangJin/join")
    public String join(){
        return "kwangJinjoin";
    }
}
