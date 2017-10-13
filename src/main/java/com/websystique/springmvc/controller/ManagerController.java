package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.Employees;
import com.websystique.springmvc.model.Positions;
import com.websystique.springmvc.service.EmployeeService;
import com.websystique.springmvc.service.PaymentsService;
import com.websystique.springmvc.service.PotentialClientsService;
import com.websystique.springmvc.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    PotentialClientsService potentialClientsService;
    @Autowired
    TaskService taskService;
    @Autowired
    EmployeeService employeeService;


    @ModelAttribute("company")
    public Companies createCompany() {
        return new Companies();
    }
    @ModelAttribute("employee")
    public Employees createEmployee() {
        return new Employees();
    }
    @ModelAttribute("position")
    public Positions createPosition() {
        return new Positions();
    }

    //INITIAL DATA
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String showManagerInterface(ModelMap model) {
        model.addAttribute("clients",potentialClientsService.findAll());
        model.addAttribute("tasks",taskService.getManagerTasks());
        model.addAttribute("owntasks",taskService.getByEmployee(1));
        return "managers";
    }

    //INITIAL DATA
    @RequestMapping(value = {"/supermanager"}, method = RequestMethod.GET)
    public String showSuperManagerInterface(ModelMap model) {
        model.addAttribute("clients",potentialClientsService.findAll());
        model.addAttribute("tasks",taskService.getManagerTasks());
        model.addAttribute("owntasks",taskService.getByEmployee(6));
        model.addAttribute("managers",employeeService.findByPosition(3));
        return "supermanager";
    }

}
