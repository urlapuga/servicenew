package com.websystique.springmvc.controller;


import com.websystique.springmvc.model.kofe.KofePlaces;
import com.websystique.springmvc.model.kofe.KofeWorkers;
import com.websystique.springmvc.service.kofe.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kofe/edit/")
public class KofeWorkersController {

    @Autowired
    WorkersService workersService;

    @RequestMapping(value = {"/worker/add/{name}/{phone}"})
    public String addType(ModelMap model, @PathVariable String name, @PathVariable String phone) {

        workersService.add(new KofeWorkers(name,phone));
        model.addAttribute("message","Работник создан");
        return "kofe/message";
    }

    @RequestMapping(value = {"/worker/del/{id}/"})
    public String removeType(ModelMap model, @PathVariable Integer id) {
        workersService.deleteById(id);
        model.addAttribute("message","Работник удален");
        return "kofe/message";
    }

}
