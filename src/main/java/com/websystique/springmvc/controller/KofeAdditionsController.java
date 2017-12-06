package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.kofe.KofeAdditions;
import com.websystique.springmvc.model.kofe.KofeAdditionsItems;
import com.websystique.springmvc.model.kofe.KofeIngredients;
import com.websystique.springmvc.service.kofe.AdditionsItemsService;
import com.websystique.springmvc.service.kofe.AdditionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kofe/edit/")
public class KofeAdditionsController {

    @Autowired
    AdditionsService additionsService;
    @Autowired
    AdditionsItemsService additionsItemsService;


    @RequestMapping(value = {"/addition/add/{name}/"})
    public String addAdddition(ModelMap model, @PathVariable String name) {
        additionsService.add(new KofeAdditions(name));
        model.addAttribute("message", "Дополнение создано");
        return "kofe/message";
    }

    @RequestMapping(value = {"/addition/del/{id}/"})
    public String removeAddition(ModelMap model, @PathVariable Integer id) {
        additionsService.deleteById(id);
        model.addAttribute("message", "Дополнение удалено");
        return "kofe/message";
    }

    @RequestMapping(value = {"/additionitem/del/{id}/"})
    public String removeAdditionItem(ModelMap model, @PathVariable Integer id) {
        additionsItemsService.deleteById(id);
        model.addAttribute("message", "Элемент удален");
        return "kofe/message";
    }

    @RequestMapping(value = {"/additionitem/add/{id}/{additionId}/"})
    public String addAdditionItem(ModelMap model, @PathVariable Integer id,@PathVariable Integer additionId) {
        additionsItemsService.add(new KofeAdditionsItems(id,additionId));
        model.addAttribute("message", "Элемент добавлен");
        return "kofe/message";
    }
}
