package com.websystique.springmvc.controller;


import com.websystique.springmvc.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/data")
public class DataController {

    @Autowired
    PaymentsService paymentsService;

    //BUHGALTER
    @RequestMapping(value = {"/payments"}, method = RequestMethod.GET)
    public String showBuhgalter(ModelMap model) {
        model.addAttribute("data",paymentsService.findAll());
        return "data/payments";
    }
}
