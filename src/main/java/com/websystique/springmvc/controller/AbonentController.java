package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.Subscribers;
import com.websystique.springmvc.model.Tarifs;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/")
public class AbonentController {

    @Autowired
    SubscriberService subscriberService;

    @Autowired
    TarifService tarifService;

    @Autowired
    DevicesService devicesService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    TaskService taskService;

    @Autowired
    TaskTypeService taskTypeService;

    @Autowired
    PaymentsService paymentsService;

    @ModelAttribute("task")
    public Tasks createTask() {
        return new Tasks();
    }




    //ABONENT

    @RequestMapping(value = {"/abonenteditor/{id}"}, method = RequestMethod.GET)
    public String showAbonentById(ModelMap model, @PathVariable Integer id) {
        Subscribers subscribers = subscriberService.getById(id);

        if (subscribers == null) {
            model.addAttribute("error", "Договор не найден");
            return "error";
        }


        Tarifs tarifs = tarifService.getById(subscribers.getTarif());


        model.addAttribute("employee", employeeService.findById(1));
        model.addAttribute("payments",paymentsService.bySubscriber(id));
        model.addAttribute("subscriber", subscribers);
        model.addAttribute("tasks", taskService.getBySubscriber(id));
        model.addAttribute("tarif", tarifs);
        model.addAttribute("tarifs", tarifService.findAll());
        model.addAttribute("tasktypes", taskTypeService.findAll());
        model.addAttribute("devices", devicesService.findAll());
        return "abonenteditor";
    }

    @RequestMapping(value = {"/newsubscriber/{address}/{room}/{phone}/{name}/"}, method = RequestMethod.GET)
    public String createSubscriber(@PathVariable Integer address,@PathVariable Integer room,@PathVariable String phone,
                                   @PathVariable String name,ModelMap model) {

        Subscribers subscribers = new Subscribers(name,phone,address,room);
        subscribers.setTarif(0);
        subscribers = subscriberService.addGet(subscribers);
        model.addAttribute("error",subscribers.getId());
        return "error";
    }

    @RequestMapping(value = {"/saveabonent"}, method = RequestMethod.POST)
    public String saveAbonent(@Valid Subscribers subscribers, BindingResult result,
                              ModelMap model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("CP1251");
        System.out.println(subscribers);
        subscriberService.update(subscribers);

        return "redirect:/abonenteditor/" + subscribers.getId();
    }

    @RequestMapping(value = {"/abonentsearch"})
    public String abonentSearch(){
        return "abonentsearch";
    }

}
