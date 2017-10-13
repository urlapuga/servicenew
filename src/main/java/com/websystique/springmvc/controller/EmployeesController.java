package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.Employees;
import com.websystique.springmvc.model.Positions;
import com.websystique.springmvc.service.CompanyService;
import com.websystique.springmvc.service.EmployeeService;
import com.websystique.springmvc.service.PositionsService;
import com.websystique.springmvc.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class EmployeesController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    CompanyService companyService;
    @Autowired
    PositionsService positionsService;
    @Autowired
    TaskService taskService;


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

    @RequestMapping(value = {"/newemployee"}, method = RequestMethod.POST)
    public String createEmployee(@Valid Employees employee, BindingResult result,
                                 ModelMap model) {
        employeeService.add(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = {"/edit-employee-{id}"}, method = RequestMethod.GET)
    public String editEmployee(@PathVariable String id, ModelMap model) {
        model.addAttribute("employee", employeeService.findById(Integer.parseInt(id)));
        model.addAttribute("tasks",taskService.getByEmployee(Integer.parseInt(id)));
        return "employeeeditor";
    }

    @RequestMapping(value = {"/update-employee"}, method = RequestMethod.POST)
    public String saveEmployee(@Valid Employees employee, BindingResult result,
                               ModelMap model) {
        employeeService.update(employee);
        return "redirect:/edit-employee-"+employee.getId();
    }

}
