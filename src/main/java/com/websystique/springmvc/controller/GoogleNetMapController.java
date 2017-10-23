package com.websystique.springmvc.controller;

import com.websystique.springmvc.service.DevicesService;
import com.websystique.springmvc.service.OpticLinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class GoogleNetMapController {

    @Autowired
    DevicesService devicesService;
    @Autowired
    OpticLinesService opticLinesService;
    //INITIAL DATA

    @RequestMapping(value = {"/map"}, method = RequestMethod.GET)
    public String showManagerInterface(ModelMap model) {

        model.addAttribute("opticlines",opticLinesService.findAll());
        System.out.println(opticLinesService.findAll());
        model.addAttribute("devicelist",devicesService.findAll());
        return "netmapgoogle";
    }
}
