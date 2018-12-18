package com.dosug.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {


    @GetMapping("/main")
    public String getHomePage(){
        return "main";
    }

    @GetMapping("/carinfos")
    public String getCardInfo(){
        return "cardInfo";
    }

}
