package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.kofe.KofeItemTypes;
import com.websystique.springmvc.service.kofe.KofeItemsTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kofe/edit/")
public class KofeItemTypesController {


    @Autowired
    KofeItemsTypesService kofeItemsTypesService;

    @RequestMapping(value = {"/types/add/{name}/"})
    public String addType(ModelMap model, @PathVariable String name) {

        kofeItemsTypesService.add(new KofeItemTypes(name));
        model.addAttribute("message","Тип создан");
        return "kofe/message";
    }

    @RequestMapping(value = {"/types/del/{id}/"})
    public String removeType(ModelMap model, @PathVariable Integer id) {

        kofeItemsTypesService.deleteById(id);
        model.addAttribute("message","Тип удален");
        return "kofe/message";
    }

}
