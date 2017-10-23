package com.websystique.springmvc.service.site;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.site.SiteHeatMaps;

import java.util.List;

public interface SiteHeatMapService {

    List<SiteHeatMaps> findAll();
    List<SiteHeatMaps> findBySite(int siteId);
    void add(SiteHeatMaps entity);
}
