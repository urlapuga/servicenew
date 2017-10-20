package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Subscriberview;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Immutable
@Repository("subscriberViewDao")
public class SubscriberViewDaoImpl extends AbstractDao<Integer, Subscriberview>implements SubscriberViewDao
{

    public List<Subscriberview> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        List<Subscriberview> entitylist = (List<Subscriberview>) criteria.list();
        return entitylist;
    }

    @Override
    public List<Subscriberview> byCity(int id) {
        return getByNamedQueryWithParam("byCityId","id",String.valueOf(id));
    }

    @Override
    public List<Subscriberview> byStreet(int id) {
        return getByNamedQueryWithParam("byStreetId","id",String.valueOf(id));
    }

    @Override
    public List<Subscriberview> byBuilding(int id) {
        return getByNamedQueryWithParam("byBuildingId","id",String.valueOf(id));
    }

}
