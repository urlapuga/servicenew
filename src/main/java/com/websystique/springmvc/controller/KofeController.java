package com.websystique.springmvc.controller;

import com.google.gson.Gson;
import com.websystique.springmvc.model.kofe.KofeAdditions;
import com.websystique.springmvc.model.kofe.KofeItemTypes;
import com.websystique.springmvc.model.kofe.KofePlaces;
import com.websystique.springmvc.service.kofe.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/kofe")
public class KofeController {

    @Autowired
    KofeItemsTypesService kofeItemsTypesService;
    @Autowired
    KofeItemservice kofeItemservice;
    @Autowired
    IngredientsService ingredientsService;
    @Autowired
    PlacesService placesServicel;
    @Autowired
    WorkersService workersService;
    @Autowired
    AdditionsService additionsService;

    @RequestMapping(value = {"/"})
    public String main(ModelMap model) {

        List<KofeItemTypes> kofeItemTypesList = kofeItemsTypesService.findAll();

        model.addAttribute("types", kofeItemTypesList);

        model.addAttribute("items", kofeItemservice.findAll());

        model.addAttribute("ingredients", ingredientsService.findAll());

        model.addAttribute("places", placesServicel.findAll());

        model.addAttribute("workers", workersService.findAll());

        model.addAttribute("additions", additionsService.findAll());

        return "kofe/index";
    }

    @RequestMapping(value = {"/items/{pin}/"})
    public String getItems(ModelMap modelMap, @PathVariable String pin) {
        System.out.println("getting items");
        List<KofePlaces> places = placesServicel.getBuPin(pin);
        if(places.isEmpty())return "kofe/message";

        KofePlaces place = places.get(0);

        List<KofeItemTypes> types = kofeItemsTypesService.findAll();
        types.forEach(t->t.setItems(kofeItemservice.findAll()));
        //TODO:replace findall by find by type ... override findByType

        List<KofeAdditions> additions = additionsService.findAll();

        String addJson = new Gson().toJson(additions);
        String json = new Gson().toJson(types);
        modelMap.addAttribute("message",json+"//"+addJson);


        //List<KofeItemTypes> types = kofeItemsTypesService.findAll();


        return "kofe/message";
    }

}
