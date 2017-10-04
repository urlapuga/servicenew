package com.websystique.springmvc.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import com.websystique.springmvc.dao.SubscriberDao;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

    //SERVICES
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;
    @Autowired
    PingerService pingerService;
    @Autowired
    UserProfileService userProfileService;
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
    //Address Services
    @Autowired
    CityService cityService;
    @Autowired
    StreetService streetService;
    @Autowired
    BuildingService buildingService;
    @Autowired
    AddressService addressService;

    //ATTRIBUTES
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

    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.findAll();
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


    //ABONENT
    @RequestMapping(value = {"/abonent"}, method = RequestMethod.POST)
    public String showAbonent(ModelMap model, @RequestParam("id") String id) {
        Subscribers subscribers = subscriberService.getById(Integer.parseInt(id));

        if (subscribers == null) {
            model.addAttribute("error", "Договор не найден");
            return "error";
        }

        Tarifs tarifs = tarifService.getById(subscribers.getTarif());
        model.addAttribute("subscriber", subscribers);
        model.addAttribute("tarif", tarifs);
        return "abonent";
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

    //EPLOYEES

    @RequestMapping(value = {"/employees"}, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {

        List<Employees> resultList = employeeService.findAll();
        model.addAttribute("result", resultList);
        return "employeelist";
    }

    //PINGER
    @RequestMapping(value = {"/pinger"}, method = RequestMethod.GET)
    public String listPinger(ModelMap model) {

        List<Pinger> resultList = pingerService.findAll();
        model.addAttribute("result", resultList);
        return "pingerlist";
    }


    @RequestMapping(value = {"/newpinger"}, method = RequestMethod.POST)
    public String savePinger(@Valid Pinger pinger, BindingResult result,
                             ModelMap model) {
        pingerService.add(pinger);
        List<Pinger> resultList = pingerService.findAll();
        model.addAttribute("result", resultList);
        return "pingerlist";
    }
    //TASKS

    @RequestMapping(value = {"/tasks"}, method = RequestMethod.GET)
    public String listTasks(ModelMap model) {
        List<Tasks> tasks = taskService.findAll();
        List<TaskType> taskTypes = taskTypeService.findAll();
        model.addAttribute("tasktypes", taskTypes);
        model.addAttribute("tasks", tasks);
        return "tasklist";
    }


    @RequestMapping(value = {"/tasks"}, method = RequestMethod.POST)
    public String saveTask(@Valid Tasks tasks, BindingResult result,
                           ModelMap model) {
        System.out.println(tasks.getDateto());
        taskService.add(tasks);
        model.addAttribute("tasktypes", taskTypeService.findAll());
        model.addAttribute("tasks", taskService.findAll());
        return "/tasklist";
    }


    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "userslist";
    }

    /**
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = {"/newuser"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "registration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = {"/newuser"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result,
                           ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

		/*
         * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation
		 * and applying it on field [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
        if (!userService.isUserSSOUnique(user.getId(), user.getSsoId())) {
            FieldError ssoError = new FieldError("user", "ssoId", messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
            result.addError(ssoError);
            return "registration";
        }

        userService.saveUser(user);

        model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " registered successfully");
        //return "success";
        return "registrationsuccess";
    }


    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = {"/edit-user-{ssoId}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String ssoId, ModelMap model) {
        User user = userService.findBySSO(ssoId);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "registration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = {"/edit-user-{ssoId}"}, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
                             ModelMap model, @PathVariable String ssoId) {

        if (result.hasErrors()) {
            return "registration";
        }

		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
        if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/


        userService.updateUser(user);

        model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " updated successfully");
        return "registrationsuccess";
    }


    /**
     * This method will delete an user by it's SSOID value.
     */
    @RequestMapping(value = {"/delete-user-{ssoId}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String ssoId) {
        userService.deleteUserBySSO(ssoId);
        return "redirect:/list";
    }


    /**
     * This method will provide UserProfile list to views
     */


}
