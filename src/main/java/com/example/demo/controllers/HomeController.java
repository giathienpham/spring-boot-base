package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    Environment env;

    @RequestMapping("/home")
    public String test(Model model) {
        String value = env.getProperty("spring.application.name");
        model.addAttribute("value", value);

        return "home/index.html";
    }
}
