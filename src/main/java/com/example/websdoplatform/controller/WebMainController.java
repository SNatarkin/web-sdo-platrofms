package com.example.websdoplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebMainController {

    @GetMapping("/main")
    public String getMainPage(){
        return "mainPage";
    }
}
