package com.websystique.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/image/")
public class KofeImageController {
    @RequestMapping(value = {"/{id}"})
    public String addIngredient(ModelMap model,@PathVariable String id) {
        System.out.println("getting image");
        model.addAttribute("id",id);
        return "image";
    }
}
