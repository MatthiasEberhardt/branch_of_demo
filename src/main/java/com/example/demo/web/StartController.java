package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class StartController {

    @RequestMapping("/")
    public String start(){
        return "index";
    }

    @RequestMapping("")
    public String start2(){
        return "index";
    }
}
