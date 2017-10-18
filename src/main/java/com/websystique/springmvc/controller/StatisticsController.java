package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.Employees;
import com.websystique.springmvc.model.Positions;
import com.websystique.springmvc.model.Tasks;
import com.websystique.springmvc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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
