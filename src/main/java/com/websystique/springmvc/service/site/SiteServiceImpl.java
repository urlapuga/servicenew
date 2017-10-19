package com.websystique.springmvc.service.site;

import com.websystique.springmvc.dao.site.SiteDao;
import com.websystique.springmvc.model.site.SiteSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("siteService")
@Transactional
public class SiteServiceImpl implements SiteService {

    @Autowired
    private SiteDao dao;

    public List<SiteSite> findAll() {
        return dao.findAll();
    }

    @Override
    public SiteSite getById(int id) {
        return dao.getById(id);
    }

}
