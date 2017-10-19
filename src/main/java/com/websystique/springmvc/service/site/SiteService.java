package com.websystique.springmvc.service.site;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.site.SiteSite;

import java.util.List;

public interface SiteService {

    List<SiteSite> findAll();
    SiteSite getById(int id);
}
