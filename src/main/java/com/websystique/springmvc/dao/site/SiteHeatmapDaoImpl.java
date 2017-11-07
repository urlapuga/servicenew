package com.websystique.springmvc.dao.site;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.site.SiteHeatMaps;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("siteHeatMapDao")
public class SiteHeatmapDaoImpl extends AbstractDao<Integer, SiteHeatMaps> implements SiteHeatmapDao
{

    public List<SiteHeatMaps> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<SiteHeatMaps> entitylist = (List<SiteHeatMaps>) criteria.list();
        return entitylist;
    }

    @Override
    public List<SiteHeatMaps> getBySite(int siteId) {
        return getByNamedQueryWithParam("getHeatMapBySite","siteId",String.valueOf(siteId));
    }

    @Override
    public void add(SiteHeatMaps entity) {
        persist(entity);
    }

}
