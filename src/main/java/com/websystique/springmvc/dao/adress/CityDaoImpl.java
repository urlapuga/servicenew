package com.websystique.springmvc.dao.adress;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.address.AddrCities;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("citiesDao")
public class CityDaoImpl extends AbstractDao<Integer, AddrCities>implements CityDao
{

    public List<AddrCities> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<AddrCities> entitylist = (List<AddrCities>) criteria.list();
        return entitylist;
    }

    public void add(AddrCities entity) {
        persist(entity);
    }

    public void update(AddrCities entity) {
        persistupdate(entity);
    }
}
