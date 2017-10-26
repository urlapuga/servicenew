package com.websystique.springmvc.dao.site;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.site.SiteSite;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("siteDao")
public class SiteDaoImpl extends AbstractDao<Integer, SiteSite>implements SiteDao
{
    public List<SiteSite> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<SiteSite> entitylist = (List<SiteSite>) criteria.list();
        return entitylist;
    }

    @Override
    public SiteSite getById(int id) {
        return getByKey(id);
    }
}
