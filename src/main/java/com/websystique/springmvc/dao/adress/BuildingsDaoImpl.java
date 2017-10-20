package com.websystique.springmvc.dao.adress;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.address.AddrBuildings;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("buildingsDao")
public class BuildingsDaoImpl extends AbstractDao<Integer, AddrBuildings>implements BuildingsDao
{

    public List<AddrBuildings> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<AddrBuildings> entitylist = (List<AddrBuildings>) criteria.list();
        return entitylist;
    }

    @Override
    public List<AddrBuildings> byStreet(int streetId) {
        return getByNamedQueryWithParam("byStreet","streetId",String.valueOf(streetId));
    }

    public void add(AddrBuildings entity) {
        persist(entity);
    }

    public void update(AddrBuildings entity) {
        persistupdate(entity);
    }
}
