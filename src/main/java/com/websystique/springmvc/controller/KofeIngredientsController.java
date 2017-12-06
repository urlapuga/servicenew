package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.kofe.KofeIngredients;
import com.websystique.springmvc.model.kofe.KofeItems;
import com.websystique.springmvc.service.kofe.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kofe/edit/")
public class KofeIngredientsController {

    @Autowired
    IngredientsService ingredientsService;

    @RequestMapping(value = {"/ingredients/add/{name}/"})
    public String addIngredient(ModelMap model, @PathVariable String name) {
        ingredientsService.add(new KofeIngredients(name));
        model.addAttribute("message", "Ингредиент создан");
        return "kofe/message";
    }

    @RequestMapping(value = {"/ingredients/del/{id}/"})
    public String removeIngredient(ModelMap model, @PathVariable Integer id) {
        ingredientsService.deleteById(id);
        model.addAttribute("message", "Ингредиент удален");
        return "kofe/message";
    }
}
