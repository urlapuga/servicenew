package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.Employees;
import com.websystique.springmvc.model.Positions;
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
public class EmployeesController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    CompanyService companyService;
    @Autowired
    PositionsService positionsService;
    @Autowired
    TaskService taskService;
    @Autowired
    TaskTypeService taskTypeService;

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
        return "redirect:/1";
    }

    @RequestMapping(value = {"/editemployee/{id}"}, method = RequestMethod.GET)
    public String editEmployee(@PathVariable Integer id, ModelMap model) {

        Employees employees = employeeService.findById(id);
        if(employees==null){
            model.addAttribute("error","Сотьрудник не найден");

            return "error";
        }

        model.addAttribute("employee", employees);
        model.addAttribute("tasks", taskService.getByEmployee(id));
        model.addAttribute("taskTypes",taskTypeService.findAll());
        return "employeeeditor";
    }

    @RequestMapping(value = {"/updateemployee"}, method = RequestMethod.POST)
    public String saveEmployee(@Valid Employees employee, BindingResult result,
                               ModelMap model) {
        employeeService.update(employee);
        return "redirect:/editemployee/" + employee.getId();
    }

}
