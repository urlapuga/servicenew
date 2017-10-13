package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.Employees;
import com.websystique.springmvc.model.Positions;
import com.websystique.springmvc.service.CompanyService;
import com.websystique.springmvc.service.EmployeeService;
import com.websystique.springmvc.service.PositionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class DirectorController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    CompanyService companyService;
    @Autowired
    PositionsService positionsService;

    @ModelAttribute("employee")
    public Employees createEmployee() {
        return new Employees();
    }

    @ModelAttribute("position")
    public Positions createPosition() {
        return new Positions();
    }

    @ModelAttribute("company")
    public Companies createCompany() {
        return new Companies();
    }

    @RequestMapping(value = {"/director"}, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {
        model.addAttribute("companies",companyService.findAll());
        model.addAttribute("result", employeeService.findAll());
        model.addAttribute("positions",positionsService.findAll());
        return "director";
    }
}
