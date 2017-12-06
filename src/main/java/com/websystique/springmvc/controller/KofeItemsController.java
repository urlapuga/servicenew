package com.websystique.springmvc.controller;


import com.websystique.springmvc.model.kofe.KofeItemTypes;
import com.websystique.springmvc.model.kofe.KofeItems;
import com.websystique.springmvc.service.kofe.KofeItemservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/kofe/edit/")
public class KofeItemsController {

    @Autowired
    KofeItemservice kofeItemservice;

    @RequestMapping(value = {"/items/add/{name}/{type}"})
    public String addItem(ModelMap model, @PathVariable String name, @PathVariable Integer type) {
        kofeItemservice.add(new KofeItems(name, type));
        model.addAttribute("message", "Товар создан");
        return "kofe/message";
    }

    @RequestMapping(value = {"/items/del/{id}/"})
    public String removeItem(ModelMap model, @PathVariable Integer id) {
        kofeItemservice.deleteById(id);
        model.addAttribute("message", "Товар удален");
        return "kofe/message";
    }


    @RequestMapping(value = {"/items/update/{id}/{name}/{cost}/{type}/{addition}/"})
    public String updateItem(ModelMap model, @PathVariable Integer id, @PathVariable String name,
                             @PathVariable double cost, @PathVariable Integer type, @PathVariable Integer addition,
                             HttpServletRequest request) {

        KofeItems kofeItems = kofeItemservice.getById(id);
        kofeItems.setName(name);
        kofeItems.setCost(cost);
        kofeItems.setType(type);
        kofeItems.setAddition(addition);
        kofeItemservice.update(kofeItems);
        model.addAttribute("message", "Товар обновлен");
        return "message";
    }
}
