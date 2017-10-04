package com.websystique.springmvc.dao.adress;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.address.AddrStreets;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("streetsDao")
public class StreetDaoImpl extends AbstractDao<Integer, AddrStreets>implements StreetDao
{

    public List<AddrStreets> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<AddrStreets> entitylist = (List<AddrStreets>) criteria.list();
        return entitylist;
    }

    public void add(AddrStreets entity) {
        persist(entity);
    }

    public void update(AddrStreets entity) {
        persistupdate(entity);
    }
}
