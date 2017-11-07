package com.websystique.springmvc.service.site;

import com.websystique.springmvc.dao.site.PagesDao;
import com.websystique.springmvc.model.site.SitePages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("pagesService")
@Transactional
public class PagesServiceImpl implements PagesService {

    @Autowired
    private PagesDao dao;

    @Override
    public List<SitePages> bySite(int id) {
        return dao.sitePages(id);
    }
}
