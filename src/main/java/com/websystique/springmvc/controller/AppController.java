package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.*;
import com.websystique.springmvc.model.address.AddrAdress;
import com.websystique.springmvc.model.address.AddrBuildings;
import com.websystique.springmvc.model.address.AddrCities;
import com.websystique.springmvc.model.address.AddrStreets;
import com.websystique.springmvc.service.*;
import com.websystique.springmvc.service.adress.AddressService;
import com.websystique.springmvc.service.adress.BuildingService;
import com.websystique.springmvc.service.adress.CityService;
import com.websystique.springmvc.service.adress.StreetService;
import com.websystique.springmvc.service.chat.ChatRoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

    //SERVICES
    @Autowired
    TaskService taskService;
    @Autowired
    PingerService pingerService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    MessageSource messageSource;
    @Autowired
    TaskTypeService taskTypeService;
    @Autowired
    SubscriberService subscriberService;
    @Autowired
    TarifService tarifService;
    @Autowired
    PaymentsService paymentsService;
    @Autowired
    PositionsService positionsService;
    @Autowired
    DevicesService devicesService;

    //Address Services
    @Autowired
    CityService cityService;
    @Autowired
    StreetService streetService;
    @Autowired
    BuildingService buildingService;
    @Autowired
    AddressService addressService;
    @Autowired
    ChatRoomsService chatRoomsService;

    //ATTRIBUTES
    @ModelAttribute("employee")
    public Employees createEmployee() {
        return new Employees();
    }

    @ModelAttribute("position")
    public Positions createPosition() {
        return new Positions();
    }

    @ModelAttribute("pinger")
    public Pinger createPinger() {
        return new Pinger();
    }

    @ModelAttribute("tasktype")
    public TaskType createTaskType() {
        return new TaskType();
    }

    @ModelAttribute("task")
    public Tasks createTask() {
        return new Tasks();
    }

    @ModelAttribute("city")
    public AddrCities createCity() {
        return new AddrCities();
    }

    @ModelAttribute("street")
    public AddrStreets createStreet() {
        return new AddrStreets();
    }

    @ModelAttribute("building")
    public AddrBuildings createBuilding() {
        return new AddrBuildings();
    }

    @ModelAttribute("address")
    public AddrAdress createAddr() {
        return new AddrAdress();
    }

    @ModelAttribute("tarif")
    public Tarifs createTarif() {
        return new Tarifs();
    }


    @ModelAttribute("company")
    public Companies createCompany() {
        return new Companies();
    }

    @ModelAttribute("subscriber")
    public Subscribers createSubscriber() {
        return new Subscribers();
    }


    @RequestMapping(value = {"/favicon.ico"}, method = RequestMethod.GET)
    public String favicon(ModelMap model) {
        return "static/favicon.ico";
    }


    //Addresspicker
    @RequestMapping(value = {"/addresspicker"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        model.addAttribute("cities", cityService.findAll());
        return "pickers/addresspicker";
    }


    //INDEX
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model, @PathVariable String id) {
        Positions positions = positionsService.getById(Integer.parseInt(id));
        model.addAttribute("tasktypes", taskTypeService.findAll());
        model.addAttribute("owntasks", taskService.getByEmployee(Integer.parseInt(id)));
        model.addAttribute("page", positions.getPage());
        return "index";
    }

    @RequestMapping(value = {"/technician"}, method = RequestMethod.GET)
    public String techInterface(ModelMap model) {
        return "technician";
    }

    @RequestMapping(value = {"/supertechnician"}, method = RequestMethod.GET)
    public String superTechInterface(ModelMap model) {
        model.addAttribute("tasks", taskService.getTechnicianTasks());
        return "supertechnician";
    }

    //POSITIONS
    @RequestMapping(value = {"/newposition"}, method = RequestMethod.POST)
    public String createTarif(@Valid Positions position, BindingResult result,
                              ModelMap model) {
        positionsService.add(position);
        return "redirect:/1";
    }

    @RequestMapping(value = {"/deleteposition/{id}"}, method = RequestMethod.GET)
    public String deletePosition(@PathVariable String id, ModelMap model) {
        positionsService.delete(Integer.parseInt(id));
        return "redirect:/1";
    }


    //POMODORO

    @RequestMapping(value = {"/pomodoro"})
    public String showPomodoro(ModelMap model) {
        return "pomodoro";
    }

    //BUHGALTER
    @RequestMapping(value = {"/buhgalter"}, method = RequestMethod.GET)
    public String showBuhgalter(ModelMap model) {
        return "buhgalter";
    }

    //PAYMENTS
    @RequestMapping(value = {"/paymentss"}, method = RequestMethod.GET)
    public String showPayments(ModelMap model) {
        System.out.println(paymentsService.findAll());
        return "buhgalter";
    }

    //TARIF
    @RequestMapping(value = {"/tarif"}, method = RequestMethod.GET)
    public String showTarif(ModelMap model) {
        List<Tarifs> tarifsList = tarifService.findAll();
        model.addAttribute("tarifs", tarifsList);
        return "tarif";
    }


    @RequestMapping(value = {"/tarif"}, method = RequestMethod.POST)
    public String createTarif(@Valid Tarifs tarif, BindingResult result,
                              ModelMap model) {
        tarifService.add(tarif);
        List<Tarifs> tarifsList = tarifService.findAll();
        model.addAttribute("tarifs", tarifsList);
        return "tarif";
    }

    @RequestMapping(value = {"/delete-tarif-{id}"}, method = RequestMethod.GET)
    public String deleteTarif(@PathVariable String id) {
        tarifService.delete(Integer.parseInt(id));
        return "redirect:/tarif";
    }



    //OPERATOR
    @RequestMapping(value = {"/operator"}, method = RequestMethod.GET)
    public String operator(ModelMap model) {

        model.addAttribute("cities", cityService.findAll());
        model.addAttribute("streets", streetService.findAll());
        model.addAttribute("buildings", buildingService.findAll());
        return "operator";
    }


    //ADDRESS
    @RequestMapping(value = {"/adresses"}, method = RequestMethod.GET)
    public String listAdress(ModelMap model) {

        model.addAttribute("cities", cityService.findAll());
        model.addAttribute("streets", streetService.findAll());
        model.addAttribute("buildings", buildingService.findAll());
        return "adresslist";
    }

    //TASK TYPES
    @RequestMapping(value = {"/tasktypes"}, method = RequestMethod.GET)
    public String listTaskTypes(ModelMap model) {
        List<TaskType> resultList = taskTypeService.findAll();
        model.addAttribute("result", resultList);
        return "tasktypelist";
    }

    @RequestMapping(value = {"/newtasktype"}, method = RequestMethod.POST)
    public String saveTaskType(@Valid TaskType taskType, BindingResult result,
                               ModelMap model) {
        taskTypeService.add(taskType);
        List<TaskType> resultList = taskTypeService.findAll();
        model.addAttribute("result", resultList);
        return "tasktypelist";
    }

    @RequestMapping(value = {"/delete-tasktype-{id}"}, method = RequestMethod.GET)
    public String deleteTaskType(@PathVariable String id) {
        taskTypeService.delete(Integer.parseInt(id));
        return "redirect:/tasktypes";
    }


    //PINGER

    @RequestMapping(value = {"/pinger"}, method = RequestMethod.GET)
    public String listPinger(ModelMap model) {

        List<Pinger> resultList = pingerService.findAll();
        model.addAttribute("result", resultList);
        return "pingerlist";
    }

    @RequestMapping(value = {"/delete-pinger-{id}"}, method = RequestMethod.GET)
    public String deletePinger(@PathVariable String id) {
        pingerService.deleteById(Integer.parseInt(id));
        return "redirect:/pinger";
    }

    @RequestMapping(value = {"/newpinger"}, method = RequestMethod.POST)
    public String savePinger(@Valid Pinger pinger, BindingResult result,
                             ModelMap model) {
        pingerService.add(pinger);
        List<Pinger> resultList = pingerService.findAll();
        model.addAttribute("result", resultList);
        return "pingerlist";
    }


}
