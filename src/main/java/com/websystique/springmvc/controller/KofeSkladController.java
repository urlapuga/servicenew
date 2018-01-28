package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.kofe.KofeIngredients;
import com.websystique.springmvc.model.kofe.KofeMainSklad;
import com.websystique.springmvc.service.kofe.IngredientsService;
import com.websystique.springmvc.service.kofe.KofeMainSkladService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/kofe/sklad/")
public class KofeSkladController {
    @Autowired
    KofeMainSkladService skladService;

    @Autowired
    IngredientsService ingredientsService;


    @RequestMapping(value = {"/add"})
    public String addIngredient(ModelMap model) {
        KofeMainSklad skladIngredient = new KofeMainSklad();
        skladIngredient.setIngredient(1);
        skladIngredient.setAmount(1.1);
        
        skladService.addIngredient(skladIngredient);
        model.addAttribute("message","готово");
        return "kofe/message";
    }

    @RequestMapping(value = {"/"})
    public String showSklad(ModelMap model) {
        List<KofeMainSklad> skladList =skladService.findAll();
        Map<Integer,KofeIngredients> integerKofeIngredientsMap = new HashMap<>();
        ingredientsService.findAll().forEach(i->integerKofeIngredientsMap.put(i.getId(),i));

        model.addAttribute("ingredientList",integerKofeIngredientsMap);
        model.addAttribute("skladList",skladList);
        return "kofe/tables/sklad";
    }
}
