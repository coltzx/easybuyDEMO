package com.cc.easybuy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController {
    @RequestMapping("/t1")
    public  String t1(){
        System.out.println("欢迎来到本店");
        return "qw";
    }
}
