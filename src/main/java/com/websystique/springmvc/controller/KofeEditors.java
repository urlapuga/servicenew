package com.websystique.springmvc.controller;


import com.websystique.springmvc.dao.kofe.AddItemsViewDao;
import com.websystique.springmvc.model.kofe.*;
import com.websystique.springmvc.service.kofe.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/kofe/editor/")
public class KofeEditors {

    @Autowired
    KofeItemservice kofeItemservice;
    @Autowired
    PlacesService placesService;
    @Autowired
    WorkersService workersService;
    @Autowired
    IngredientsService ingredientsService;
    @Autowired
    AdditionsService additionsService;
    @Autowired
    AdditionItemViewService additionItemViewService;
    @Autowired
    ItemIngredientsViewService itemIngredientsViewService;
    @Autowired
    KofeItemsTypesService kofeItemsTypesService;

    @RequestMapping(value = {"/item/{id}"})
    public String editItem(ModelMap model, @PathVariable Integer id) {
        List<KofeIngredients> ingredientsList =ingredientsService.findAll();
        KofeItems kofeItems = kofeItemservice.getById(id);

        model.addAttribute("types",kofeItemsTypesService.findAll());
        model.addAttribute("additions",additionsService.findAll());
        model.addAttribute("itemingredients",itemIngredientsViewService.findByItem(id));
        model.addAttribute("ingredients",ingredientsList);
        model.addAttribute("item", kofeItems);
        return "kofe/editors/itemeditor";
    }

    @RequestMapping(value = {"/place/{id}"})
    public String editPlace(ModelMap model, @PathVariable Integer id) {

        KofePlaces places = placesService.getById(id);
        model.addAttribute("place", places);
        return "kofe/editors/placeeditor";
    }

    @RequestMapping(value = {"/worker/{id}"})
    public String editWorker(ModelMap model, @PathVariable Integer id) {
        KofeWorkers workers = workersService.getById(id);
        model.addAttribute("worker", workers);
        return "kofe/editors/workereditor";
    }

    @RequestMapping(value = {"/addition/{id}"})
    public String editAddition(ModelMap model, @PathVariable Integer id) {
        KofeAdditions additions  = additionsService.getById(id);

        List<KofeAddItemView> addItemViews = additionItemViewService.findByAddition(id);

        model.addAttribute("addition", additions);
        model.addAttribute("additionItems",addItemViews);
        model.addAttribute("items",kofeItemservice.findAll());

        return "kofe/editors/additioneditor";
    }

}
