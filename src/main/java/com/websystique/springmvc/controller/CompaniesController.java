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
public class CompaniesController {

    @ModelAttribute("employees")
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

    @ModelAttribute("task")
    public Tasks createTask() {
        return new Tasks();
    }


    @Autowired
    CompanyService companyService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PositionsService positionsService;
    @Autowired
    TaskService taskService;
    @Autowired
    TaskTypeService taskTypeService;

    @RequestMapping(value = {"/newcompany"}, method = RequestMethod.POST)
    public String saveTaskType(@Valid Companies company, BindingResult result,
                               ModelMap model) {
        companyService.add(company);
        return "employeelist";
    }

    @RequestMapping(value = {"/delete-company-{id}"}, method = RequestMethod.GET)
    public String deleteCompany(@PathVariable String id) {
        companyService.deleteById(Integer.parseInt(id));
        return "employeelist";
    }

    @RequestMapping(value = {"/edit-company-{id}"}, method = RequestMethod.GET)
    public String editCompany(@PathVariable String id, ModelMap model) {
        Companies companies = companyService.getById(Integer.valueOf(id));
       model.addAttribute("tasks",taskService.getByCompany(Integer.parseInt(id)));
        model.addAttribute("company", companies);
        model.addAttribute("employee", employeeService.findByCompanyId(Integer.valueOf(id)));
        model.addAttribute("positions",positionsService.findAll());
        model.addAttribute("tasktypes",taskTypeService.findAll());
        return "companyeditor";
    }

    @RequestMapping(value = {"/save-company"}, method = RequestMethod.POST)
    public String saveCompany(@Valid Companies company, BindingResult result, ModelMap model) {
        System.out.println(company);
        companyService.update(company);
        return "redirect:edit-company-"+company.getId();
    }



}
