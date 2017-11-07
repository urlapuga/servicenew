package com.websystique.springmvc.dao.site;

import com.websystique.springmvc.model.site.SiteHeatMaps;

import java.util.List;

public interface SiteHeatmapDao {

    List<SiteHeatMaps> findAll();
    List<SiteHeatMaps> getBySite(int siteId);
    void add(SiteHeatMaps entity);

}
