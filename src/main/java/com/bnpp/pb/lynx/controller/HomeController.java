package com.bnpp.pb.lynx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class HomeController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }
} 