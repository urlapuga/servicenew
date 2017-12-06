package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.kofe.KofeItemTypes;
import com.websystique.springmvc.model.kofe.KofePlaces;
import com.websystique.springmvc.service.kofe.PlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kofe/edit/")
public class KofePlacesController {

    @Autowired
    PlacesService placesService;

    @RequestMapping(value = {"/places/add/{addr}/{pin}"})
    public String addType(ModelMap model, @PathVariable String addr,@PathVariable Integer pin) {
        placesService.add(new KofePlaces(addr,pin));
        model.addAttribute("message","Точка создана");
        return "kofe/message";
    }

    @RequestMapping(value = {"/places/del/{id}/"})
    public String removeType(ModelMap model, @PathVariable Integer id) {
        placesService.deleteById(id);
        model.addAttribute("message","Точка удалена");
        return "kofe/message";
    }
}
