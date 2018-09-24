package com.devopsbuddy.web.controller;

import org.springframework.stereotype.Controller;

@Controller
public class IndexController {

    public String indexPage() {
        return "index";
    }
}
