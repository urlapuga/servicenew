package com.websystique.springmvc.controller;

import com.websystique.springmvc.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @RequestMapping(value = {"/statistics"}, method = RequestMethod.GET)
    public String saveTaskType(ModelMap model) {
        System.out.println(statisticsService.allManworkList());

        return "statistics";
    }


}
