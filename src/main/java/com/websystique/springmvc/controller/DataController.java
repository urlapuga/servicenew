package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.Subscribers;
import com.websystique.springmvc.model.Subscriberview;
import com.websystique.springmvc.service.PaymentsService;
import com.websystique.springmvc.service.SubscriberService;
import com.websystique.springmvc.service.SubscriberViewService;
import com.websystique.springmvc.service.adress.BuildingService;
import com.websystique.springmvc.service.adress.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/data")
public class DataController {

    @Autowired
    PaymentsService paymentsService;

    @Autowired
    StreetService streetService;

    @Autowired
    BuildingService buildingService;

    @Autowired
    SubscriberViewService subscriberViewService;

    //PAYMENTS
    @RequestMapping(value = {"/payments"}, method = RequestMethod.GET)
    public String showBuhgalter(ModelMap model) {
        model.addAttribute("data", paymentsService.findAll());
        return "data/payments";
    }

    //STREETSBYCITY
    @RequestMapping(value = {"/streets/{cityId}"}, method = RequestMethod.GET)
    public String showCityStreets(ModelMap model, @PathVariable String cityId) {
        model.addAttribute("streets", streetService.byCity(Integer.parseInt(cityId)));
        return "pickers/streetpicker";
    }

    //BUILDINGSBYSTREET
    @RequestMapping(value = {"/buildings/{streetId}"}, method = RequestMethod.GET)
    public String showStrrtBuildings(ModelMap model, @PathVariable String streetId) {
        model.addAttribute("buildings", buildingService.byStreet(Integer.parseInt(streetId)));
        return "pickers/buildingpicker";
    }

    //GLOBALSUBSRIBERLIST
    @RequestMapping(value = {"/subscribers/{idBy}/{id}"}, method = RequestMethod.GET)
    public String showSubscribers(ModelMap model, @PathVariable String id, @PathVariable String idBy) {
        List<Subscriberview> subsList = new ArrayList<>();
        System.out.println(idBy);
        if (idBy.equals("city")) {
            subsList = subscriberViewService.byCity(Integer.parseInt(id));
        }
        else if (idBy.equals("street")) {
            subsList = subscriberViewService.byStreet(Integer.parseInt(id));
        }
        else if (idBy.equals("building")) {
            subsList = subscriberViewService.byBuilding(Integer.parseInt(id));
        } else {
            model.addAttribute("error", "Некорректный запрос");
            return "error";
        }

        model.addAttribute("subscribers", subsList);
        return "table-subscriberview";
    }

}
