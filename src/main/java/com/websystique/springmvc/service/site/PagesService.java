package com.websystique.springmvc.service.site;

import com.websystique.springmvc.model.site.SitePages;

import java.util.List;

public interface PagesService {

    List<SitePages> bySite(int id);
}
