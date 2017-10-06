package com.websystique.springmvc.controller;

import com.websystique.springmvc.service.PaymentsService;
import com.websystique.springmvc.service.PotentialClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    PotentialClientsService potentialClientsService;

    //BUHGALTER
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String showBuhgalter(ModelMap model) {
        model.addAttribute("clients",potentialClientsService.findAll());
        return "managers";
    }

    @RequestMapping(value = {"/googleCompanies"}, method = RequestMethod.GET)
    public String showGoogleCompanies(ModelMap model) {



        model.addAttribute("clients",potentialClientsService.findAll());
        return "managers";
    }
}
