package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/web")
public class LoginController {

    @GetMapping(value = "/login")//, method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @PostMapping(value = "/login")//, method = RequestMethod.POST)
    public String doLogin(){
        return "index";
    }
}
