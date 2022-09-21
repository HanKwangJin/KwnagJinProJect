package com.project.KwangJinProJect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JinController {

    @GetMapping("/")
    public String home(){
        return "kwangJinHome";
    }
    @GetMapping("kwangJin/signup")
    public String signUp(){
         return "kwangJinSignUp";
    }
    @GetMapping("kwangJin/list")
    public String list(){
         return "kwangJinList";
    }
}
