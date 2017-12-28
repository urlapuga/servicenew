package com.websystique.springmvc.controller;

import com.google.gson.Gson;
import com.websystique.springmvc.model.kofe.*;
import com.websystique.springmvc.service.kofe.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    AdditionItemViewService additionItemViewService;
    @Autowired
    SmenyService smenyService;

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

    @RequestMapping(value = {"/closeplace/{pin}/{placepin}/{solditems}"})
    public String closePlace(ModelMap modelMap,
                             @PathVariable String pin,
                             @PathVariable String placepin,
                             @PathVariable String solditems) {
        List<KofePlaces> places = placesServicel.getBuPin(pin);
        if (places.isEmpty()) return "kofe/message";
        KofeWorkers workers = workersService.getByPin(pin);
        if (workers == null) return "kofe/message";
        KofePlaces place = places.get(0);
        KofeSmeny smena = smenyService.getByPinWorker(pin, placepin);
        if (smena == null) return "kofe/message";

        //TODO:get item list from client
        List<KofeItems> soldItems = new ArrayList<>();

        double moneyMade = soldItems.stream().mapToDouble(KofeItems::getCost).sum();
        smena.setMoneyMade(moneyMade);
        smenyService.update(smena);


        Map<KofeItems, Integer> itemsCount = new HashMap<>();

        for (KofeItems k : soldItems) {
            itemsCount.put(k, (itemsCount.get(k)) + 1);
        }

        List<KofeItems> items = kofeItemservice.findAll();
        Map<Integer, KofeItems> itemsMap = new HashMap<>();
        items.forEach(i -> itemsMap.put(i.getId(), i));

        Map<KofeIngredients, Double> ingredientsAmounts = new HashMap<>();


        itemsCount.forEach((k, v) -> {
            //TODO: ingredientsAmounts.compute((k1,va)->(va==null)?v:Double.valueOf(va)+v);
        });
        return "kofe/message";
    }

    @RequestMapping(value = {"/items/{pin}/{placepin}"})
    public String getItems(ModelMap modelMap, @PathVariable String pin, @PathVariable String placepin) {

        System.out.println("getting items");
        List<KofePlaces> places = placesServicel.getBuPin(pin);


        if (places.isEmpty()) {
            System.out.println("no place");
            return "kofe/message";
        }


        KofeWorkers workers = workersService.getByPin(pin);
        if (workers == null) {
            System.out.println("no worker");
            return "kofe/message";
        }
        KofePlaces place = places.get(0);

        KofeSmeny kofeSmeny = new KofeSmeny();
        kofeSmeny.setWorker(workers.getId());
        kofeSmeny.setPlace(place.getId());
        smenyService.add(kofeSmeny);

        List<KofeItemTypes> types = kofeItemsTypesService.findAll();
        System.out.println(types);
        types.forEach(t -> t.setItems(kofeItemservice.findByType(t.getId())));
        System.out.println(types);
        //Получаем все дополнения
        List<KofeAdditions> additions = additionsService.findAll();
        System.out.println(additions);

      String addJson = new Gson().toJson(additions);
       System.out.println(addJson);
        String json = new Gson().toJson(types);
        System.out.println(json);
        // System.out.println("Json"+ json);
        modelMap.addAttribute("message", json + "//" + addJson);


        //List<KofeItemTypes> types = kofeItemsTypesService.findAll();


        return "kofe/message";
    }

}
