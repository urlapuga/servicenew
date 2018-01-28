package com.websystique.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PhoneController {
    @RequestMapping(value = {"/phone"})
    public String saveTaskType() {
        return "smsSender";
    }
}
