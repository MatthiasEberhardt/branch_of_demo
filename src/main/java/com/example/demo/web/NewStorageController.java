package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class NewStorageController {

    @GetMapping("/new-storage")
    public String newStorage(){
        return "new-storage";
    }
}
