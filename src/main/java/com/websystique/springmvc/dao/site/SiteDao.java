package com.websystique.springmvc.dao.site;

import com.websystique.springmvc.model.site.SiteSite;

import java.util.List;

public interface SiteDao {

    List<SiteSite> findAll();
    SiteSite getById(int id);
}
