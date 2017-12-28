package com.websystique.springmvc.controller;

import com.websystique.springmvc.actionproducer.MailProducer;
import com.websystique.springmvc.converters.MoneyConverter;
import com.websystique.springmvc.converters.PassToHashConverter;
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

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/")
public class AbonentController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;
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

    @Autowired
    RekvizityService rekvizityService;

    @Autowired
    SubscriberTarifsService subscriberTarifsService;

    @Autowired
    SubscriberHasTarifsService subscriberHasTarifsService;

    @ModelAttribute("task")
    public Tasks createTask() {
        return new Tasks();
    }

    @ModelAttribute("subscribertarifs")
    public SubscriberTarifs addTarif() {
        return new SubscriberTarifs();
    }

    @ModelAttribute("rekvizity")
    public Rekvizity createRekvizity() {
        return new Rekvizity();
    }

    //TARIFICATION
    @RequestMapping(value = {"/edittarif/{id}/{device}/{port}"}, method = RequestMethod.GET)
    public String editTarif(ModelMap model, @PathVariable Integer id, @PathVariable Integer device, @PathVariable Integer port) {
        SubscriberTarifs subscriberTarifs = subscriberHasTarifsService.getById(id);

        subscriberTarifs.setDevice(device);
        subscriberTarifs.setPort(port);
        subscriberHasTarifsService.update(subscriberTarifs);
        model.addAttribute("error","Готово");
        return "error";
    }

    @RequestMapping(value = {"/deletetarif/{id}"}, method = RequestMethod.GET)
    public String deleteTarif(ModelMap model, @PathVariable Integer id) {
        subscriberHasTarifsService.delete(id);
        model.addAttribute("error","Готово");
        return "error";
    }

    @RequestMapping(value = {"/addtarif"}, method = RequestMethod.POST)
    public String addTarif(ModelMap model,@Valid SubscriberTarifs tarif, BindingResult result) {
        subscriberHasTarifsService.add(tarif);
        return "redirect:" + request.getHeader("Referer");
    }


    //PASSWORD GENERATION
    @RequestMapping(value = {"/generatePass/{subscriberID}"}, method = RequestMethod.GET)
    public String generatePass(@PathVariable Integer subscriberID, ModelMap model) {
        Subscribers subscribers = subscriberService.getById(subscriberID);
        if (subscribers.getEmail() != null) {
            if (subscribers.getEmail().length() > 0) {
                String pass = PassToHashConverter.generatePass();
                String hash = PassToHashConverter.convert(pass);


                String text = "Ваш Договор (Логин ) - " + subscriberID + "Ваш пароль -" + pass;
                text += " Ваш пароль знаете только вы";
                MailProducer.send(subscribers.getEmail(), "Доступ в Личный кабинет", text);
                subscribers.setPassword(hash);
                subscriberService.update(subscribers);
                model.addAttribute("error", "пароль успешно сгенерирован");
            }
        } else {
            model.addAttribute("error", "Сначала внесите emzil абонента");
        }
        return "error";
    }
    //DOCUMENTS

    @RequestMapping(value = {"/showdoc/{doctype}/{subscriberID}"}, method = RequestMethod.GET)
    public String createSubscriber(@PathVariable String doctype, @PathVariable Integer subscriberID, ModelMap model) {
        Rekvizity rekvizity = rekvizityService.getBySubscriber(subscriberID);
        Subscribers subscribers = subscriberService.getById(subscriberID);

        model.addAttribute("cost", tarifService.getById(subscribers.getTarif()).getCost());
        if(subscribers.getTarif()!=0){
            String moneyString = String.valueOf(tarifService.getById(subscribers.getTarif()).getCost());
            model.addAttribute("money", MoneyConverter.convert(moneyString,rekvizity.getPdv())) ;
        }
        else{
            model.addAttribute("money", "0 грн") ;
        }

        model.addAttribute("month", MonthUkr.values()[Integer.parseInt(subscribers.getDateRegistered().toString().split("-")[1])]);
        model.addAttribute("rekvizity", rekvizity);
        return "/dogovora/" + doctype;
    }

    //ABONENT
    @RequestMapping(value = {"/abonenteditor/{id}"}, method = RequestMethod.GET)
    public String showAbonentById(ModelMap model, @PathVariable Integer id) {
        Subscribers subscribers = subscriberService.getById(id);

        if (subscribers == null) {
            model.addAttribute("error", "Договор не найден");
            return "error";
        }

        List<Subscribertarifsview> subscribertarifsviews = subscriberTarifsService.getBySubscriber(1);


        Tarifs tarifs = tarifService.getById(subscribers.getTarif());

        model.addAttribute("alltarifs", subscribertarifsviews);
        model.addAttribute("rekvizity", rekvizityService.getBySubscriber(id));
        model.addAttribute("employee", employeeService.findById(1));
        model.addAttribute("payments", paymentsService.bySubscriber(id));
        model.addAttribute("subscriber", subscribers);
        model.addAttribute("tasks", taskService.getBySubscriber(id));
        model.addAttribute("tarif", tarifs);
        model.addAttribute("tarifs", tarifService.findAll());
        model.addAttribute("tasktypes", taskTypeService.findAll());
        model.addAttribute("devices", devicesService.findAll());
        return "abonenteditor";
    }

    @RequestMapping(value = {"/newsubscriber/{address}/{room}/{phone}/{name}/"}, method = RequestMethod.GET)
    public String createSubscriber(@PathVariable Integer address, @PathVariable Integer room, @PathVariable String phone,
                                   @PathVariable String name, ModelMap model) {

        Subscribers subscribers = new Subscribers(name, phone, address, room);
        subscribers.setTarif(0);
        Rekvizity rekvizity = new Rekvizity();
        subscribers = subscriberService.addGet(subscribers);
        System.out.println(subscribers);
        rekvizity.setSubscriber(subscribers.getId());
        System.out.println(rekvizity);
        rekvizityService.add(rekvizity);
        model.addAttribute("error", subscribers.getId());
        return "error";
    }

    @RequestMapping(value = {"/saveabonent"}, method = RequestMethod.POST)
    public String saveAbonent(@Valid Subscribers subscribers, BindingResult result,
                              ModelMap model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("CP1251");
        subscriberService.update(subscribers);

        return "redirect:/abonenteditor/" + subscribers.getId();
    }

    @RequestMapping(value = {"/saverekvizity"}, method = RequestMethod.POST)
    public String saveRekvizity(@Valid Rekvizity rekvizity, BindingResult result,
                                ModelMap model, HttpServletRequest request) throws UnsupportedEncodingException {

        rekvizityService.update(rekvizity);
        return "redirect:/abonenteditor/" + rekvizity.getSubscriber();
    }


    @RequestMapping(value = {"/abonentsearch"})
    public String abonentSearch() {
        return "abonentsearch";
    }

}
