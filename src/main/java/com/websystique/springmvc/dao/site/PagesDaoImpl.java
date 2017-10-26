package com.websystique.springmvc.dao.site;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.site.SitePages;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("pagesDao")
public class PagesDaoImpl extends AbstractDao<Integer, SitePages> implements PagesDao {
    @Override
    public List<SitePages> sitePages(int siteId) {
        return getByNamedQueryWithParam("getBySite", "siteId", String.valueOf(siteId));
    }
}
