package com.websystique.springmvc.service.site;

import com.websystique.springmvc.dao.SiteHeatmapDao;
import com.websystique.springmvc.model.site.SiteHeatMaps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("siteHeatMapService")
@Transactional
public class SiteHeatMapServiceImpl implements SiteHeatMapService {

    @Autowired
    private SiteHeatmapDao dao;

    public List<SiteHeatMaps> findAll() {
        return dao.findAll();
    }

    @Override
    public List<SiteHeatMaps> findBySite(int siteId) {
        return dao.getBySite(siteId);
    }

    public void add(SiteHeatMaps entity) {

        dao.add(entity);
    }


}
