package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class CustomerController {

    @RequestMapping("/customer")
    public String m1(){
        return "";
    }
}
