package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.*;
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
import java.sql.Timestamp;

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
    @Autowired
    SubscriberService subscriberService;

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

    @RequestMapping(value = {"/editemployee/createEmployeeTask/{employeeId}/{subscriberId}/{taskType}/{taskDate}/{taskText}"}, method = RequestMethod.GET)
    public String createEmployeeTask(@PathVariable Integer employeeId,@PathVariable Integer subscriberId,
                                     @PathVariable Integer taskType,@PathVariable String taskDate,@PathVariable String taskText, ModelMap model) {

        Employees employees = employeeService.findById(employeeId);
        if(employees==null){
            model.addAttribute("error","Сотрудник не найден");
            return "error";
        }

        Subscribers subscribers = subscriberService.getById(subscriberId);
        if(subscribers==null){
            model.addAttribute("error","Абонент не найден");
            return "error";
        }

        String dateToInsrert = "";
        dateToInsrert+=taskDate.split("T")[0];
        dateToInsrert+=" "+taskDate.split("T")[1]+":00";
        Tasks tasks = new Tasks();
        tasks.setEmployeeTaskTo(employees.getId());
        tasks.setDateto(Timestamp.valueOf(dateToInsrert));
        tasks.setSubscriberId(subscriberId);
        tasks.setType(taskType);
        tasks.setText(taskText);
        tasks.setStatus(0);

        taskService.add(tasks);

        model.addAttribute("employee", employees);
        model.addAttribute("tasks", taskService.getByEmployee(employeeId));
        model.addAttribute("taskTypes",taskTypeService.findAll());
        model.addAttribute("error","Задача создана");
        return "error";
    }

    @RequestMapping(value = {"/updateemployee"}, method = RequestMethod.POST)
    public String saveEmployee(@Valid Employees employee, BindingResult result,
                               ModelMap model) {
        employeeService.update(employee);
        return "redirect:/editemployee/" + employee.getId();
    }

}
