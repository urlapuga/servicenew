package com.websystique.springmvc.dao.site;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.site.SitePages;

import java.util.List;

public interface PagesDao {

    List<SitePages> sitePages (int siteId);
}
