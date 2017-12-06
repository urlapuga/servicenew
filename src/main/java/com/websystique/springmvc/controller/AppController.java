package com.websystique.springmvc.controller;

import com.websystique.springmvc.auth.AuthChecker;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
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

    @Autowired
    HttpServletRequest request;

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

    @Autowired
    HttpSession session;
    @Autowired
    LogService logService;

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



    //INDEX
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String main(ModelMap model, HttpServletRequest request) {
        Employees employees = (Employees) session.getAttribute("employee");
        if (employees == null) {
            return "auth";
        }
        Integer position = employees.getPositionId();
        Positions positions = positionsService.getById(position);
        model.addAttribute("tasktypes", taskTypeService.findAll());
        model.addAttribute("owntasks", taskService.getByEmployee(employees.getId()));
        model.addAttribute("page", positions.getPage());
        return "index";
    }


    //AUTH
    @RequestMapping(value = {"/authorize"}, method = RequestMethod.POST)
    public String auth(ModelMap model, @RequestParam(value = "login") String login, @RequestParam(value = "pass") String pass) {
        if(login==null||pass==null) return "redirect:/auth";
        if(login.length()==0||pass.length()==0)  return "redirect:/auth";
        Employees employees = employeeService.getByLoginPass(login, pass);

        if (employees == null) {
            logService.add(new Logg("login", request.getRemoteAddr(), "error", new Timestamp(Calendar.getInstance().getTime().getTime()),"0"));
            model.addAttribute("mesage", "Неверный логин и/или пароль");
            return "auth";
        } else {
            logService.add(new Logg("login","" , "success", new Timestamp(Calendar.getInstance().getTime().getTime()),String.valueOf(employees.getId())));
            session.setAttribute("employee", employees);
            return "redirect:/";
        }
    }

    //EXIT
    @RequestMapping(value = "/exit")
    public String exit() {
        session.invalidate();
        return "auth";
    }



    //Addresspicker
    @RequestMapping(value = {"/addresspicker"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        model.addAttribute("cities", cityService.findAll());
        return "pickers/addresspicker";
    }


    @RequestMapping(value = {"/technician"}, method = RequestMethod.GET)
    public String techInterface(ModelMap model) {

        if (!AuthChecker.check(session,new Integer[]{2})) return "restricted";
        return "technician";
    }

    @RequestMapping(value = {"/supertechnician"}, method = RequestMethod.GET)
    public String superTechInterface(ModelMap model) {
        if (!AuthChecker.check(new Integer[]{6})) return "restricted";
        model.addAttribute("tasks", taskService.getTechnicianTasks());
        model.addAttribute("employees", employeeService.findAll());
        return "supertechnician";
    }

    //POSITIONS
    @RequestMapping(value = {"/newposition"}, method = RequestMethod.POST)
    public String createTarif(@Valid Positions position, BindingResult result,
                              ModelMap model) {
        if (!AuthChecker.check(session,new Integer[]{1})) return "restricted";
        Employees employees = (Employees) session.getAttribute("employee");
        logService.add(new Logg("postition", position.getName(), "add", new Timestamp(Calendar.getInstance().getTime().getTime()),String.valueOf(employees.getId())));
        positionsService.add(position);
        return "redirect:/";
    }

    @RequestMapping(value = {"/deleteposition/{id}"}, method = RequestMethod.GET)
    public String deletePosition(@PathVariable String id, ModelMap model) {
        Employees employees = (Employees) session.getAttribute("employee");
        if (!Arrays.asList(new Integer[]{1}).contains(employees.getPositionId()))return "restricted";

        logService.add(new Logg("postition",id , "delete", new Timestamp(Calendar.getInstance().getTime().getTime()),String.valueOf(employees.getId())));
        positionsService.delete(Integer.parseInt(id));
        return "redirect:/";
    }


    //POMODORO

    @RequestMapping(value = {"/pomodoro"})
    public String showPomodoro(ModelMap model) {
        return "pomodoro";
    }

    //BUHGALTER
    @RequestMapping(value = {"/buhgalter"}, method = RequestMethod.GET)
    public String showBuhgalter(ModelMap model) {
        if (!AuthChecker.check(session,new Integer[]{7})) return "restricted";
        return "buhgalter";
    }

    //PAYMENTS
    @RequestMapping(value = {"/paymentss"}, method = RequestMethod.GET)
    public String showPayments(ModelMap model) {
        if (session.getAttribute("employee") == null) return "auth";
        System.out.println(paymentsService.findAll());
        return "buhgalter";
    }

    //TARIF
    @RequestMapping(value = {"/tarif/{companyId}/"}, method = RequestMethod.GET)
    public String showTarif(ModelMap model,@PathVariable Integer companyId) {
        if (session.getAttribute("employee") == null) return "auth";
        List<Tarifs> tarifsList = tarifService.findByCompany(companyId);
        model.addAttribute("tarifs", tarifsList);
        return "redirect:"+ request.getHeader("Referer");
    }


    @RequestMapping(value = {"/tarif"}, method = RequestMethod.POST)
    public String createTarif(@Valid Tarifs tarif, BindingResult result,
                              ModelMap model) {
        if (!AuthChecker.check(session,new Integer[]{1})) return "restricted";
        Employees employees = (Employees) session.getAttribute("employee");
        logService.add(new Logg("tarif",tarif.getName() , "add", new Timestamp(Calendar.getInstance().getTime().getTime()),String.valueOf(employees.getId())));
        tarifService.add(tarif);
        List<Tarifs> tarifsList = tarifService.findAll();
        model.addAttribute("tarifs", tarifsList);
        return "redirect:"+ request.getHeader("Referer");
    }

    @RequestMapping(value = {"/delete-tarif-{id}"}, method = RequestMethod.GET)
    public String deleteTarif(@PathVariable String id) {
        if (!AuthChecker.check(session,new Integer[]{1})) return "restricted";
        Employees employees = (Employees) session.getAttribute("employee");
        logService.add(new Logg("tarif",id , "delete", new Timestamp(Calendar.getInstance().getTime().getTime()),String.valueOf(employees.getId())));
        tarifService.delete(Integer.parseInt(id));
        return "redirect:"+ request.getHeader("Referer");
    }


    //OPERATOR
    @RequestMapping(value = {"/operator"}, method = RequestMethod.GET)
    public String operator(ModelMap model) {
        if (!AuthChecker.check(session,new Integer[]{3})) return "restricted";
        model.addAttribute("cities", cityService.findAll());
        model.addAttribute("streets", streetService.findAll());
        model.addAttribute("buildings", buildingService.findAll());
        return "operator";
    }


    //ADDRESS
    @RequestMapping(value = {"/adresses"}, method = RequestMethod.GET)
    public String listAdress(ModelMap model) {
        if (session.getAttribute("employee") == null) return "auth";
        model.addAttribute("cities", cityService.findAll());
        model.addAttribute("streets", streetService.findAll());
        model.addAttribute("buildings", buildingService.findAll());
        return "redirect:"+ request.getHeader("Referer");
    }

    //TASK TYPES
    @RequestMapping(value = {"/tasktypes"}, method = RequestMethod.GET)
    public String listTaskTypes(ModelMap model) {
        if (session.getAttribute("employee") == null) return "auth";
        List<TaskType> resultList = taskTypeService.findAll();
        model.addAttribute("result", resultList);
        return "redirect:"+ request.getHeader("Referer");
    }

    @RequestMapping(value = {"/newtasktype"}, method = RequestMethod.POST)
    public String saveTaskType(@Valid TaskType taskType, BindingResult result,
                               ModelMap model) {
        if (!AuthChecker.check(session,new Integer[]{1})) return "restricted";
        Employees employees = (Employees) session.getAttribute("employee");
        logService.add(new Logg("tasktype",taskType.getName() , "add", new Timestamp(Calendar.getInstance().getTime().getTime()),String.valueOf(employees.getId())));
        taskTypeService.add(taskType);
        List<TaskType> resultList = taskTypeService.findAll();
        model.addAttribute("result", resultList);
        return "redirect:"+ request.getHeader("Referer");
    }

    @RequestMapping(value = {"/delete-tasktype-{id}"}, method = RequestMethod.GET)
    public String deleteTaskType(@PathVariable String id) {
        if (!AuthChecker.check(session,new Integer[]{1})) return "restricted";
        Employees employees = (Employees) session.getAttribute("employee");
        logService.add(new Logg("tasktype",id , "delete", new Timestamp(Calendar.getInstance().getTime().getTime()),String.valueOf(employees.getId())));
        taskTypeService.delete(Integer.parseInt(id));
        return "redirect:"+ request.getHeader("Referer");
    }


    //PINGER

    @RequestMapping(value = {"/pinger"}, method = RequestMethod.GET)
    public String listPinger(ModelMap model) {
        if (!AuthChecker.check(session,new Integer[]{2, 6})) return "restricted";
        List<Pinger> resultList = pingerService.findAll();
        model.addAttribute("result", resultList);
        return "pingerlist";
    }

    @RequestMapping(value = {"/delete-pinger-{id}"}, method = RequestMethod.GET)
    public String deletePinger(@PathVariable String id, HttpServletRequest request) {
        if (!AuthChecker.check(session,new Integer[]{2, 6})) return "restricted";
        Employees employees = (Employees) session.getAttribute("employee");
        logService.add(new Logg("pinger",id , "delete", new Timestamp(Calendar.getInstance().getTime().getTime()),String.valueOf(employees.getId())));
        pingerService.deleteById(Integer.parseInt(id));
        return "redirect:" + request.getHeader("Referer");
    }

    @RequestMapping(value = {"/newpinger"}, method = RequestMethod.POST)
    public String savePinger(@Valid Pinger pinger, BindingResult result,
                             ModelMap model, HttpServletRequest request) {

        if (!AuthChecker.check(session,new Integer[]{2, 6})) return "restricted";
        Employees employees = (Employees) session.getAttribute("employee");
        logService.add(new Logg("pinger",pinger.getIp() , "add", new Timestamp(Calendar.getInstance().getTime().getTime()),String.valueOf(employees.getId())));
        pingerService.add(pinger);
        List<Pinger> resultList = pingerService.findAll();
        model.addAttribute("result", resultList);
        return "redirect:" + request.getHeader("Referer");
    }


}
