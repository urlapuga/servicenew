package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.site.SiteHeatMaps;
import com.websystique.springmvc.model.site.SitePages;
import com.websystique.springmvc.model.site.SiteSite;
import com.websystique.springmvc.service.site.PagesService;
import com.websystique.springmvc.service.site.SiteHeatMapService;
import com.websystique.springmvc.service.site.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/site")
public class SiteController {

    @Autowired
    SiteService siteService;
    @Autowired
    PagesService pagesService;
    @Autowired
    SiteHeatMapService siteHeatMapService;


    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String saveTaskType(ModelMap model) {
        SiteSite siteSite = siteService.getById(0);
        List<SitePages> sitePages = pagesService.bySite(0);
        Map<String, String> menuMap = new HashMap<>();

        sitePages.forEach(p -> menuMap.put(p.getName(), p.getAnchor()));
        model.addAttribute("site", siteSite);
        model.addAttribute("pages", sitePages);
        model.addAttribute("menu", menuMap);
        return "site";
    }

    @RequestMapping(value = {"/heat/{siteid}/{arr}"}, method = RequestMethod.GET)
    public String saveHeatMap(ModelMap model, @PathVariable String arr,@PathVariable String siteid) {
        SiteHeatMaps siteHeatMaps = new SiteHeatMaps();
        siteHeatMaps.setHeat(arr);
        siteHeatMaps.setSite(Integer.parseInt(siteid));
        siteHeatMaps.setDate(new java.sql.Timestamp(new java.util.Date().getTime()));
        siteHeatMapService.add(siteHeatMaps);
        return "site";
    }
}
