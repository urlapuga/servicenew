package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Subscribers;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("subscriberDao")
public class SubscriberDaoImpl extends AbstractDao<Integer, Subscribers>implements SubscriberDao
{

    public List<Subscribers> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Subscribers> entitylist = (List<Subscribers>) criteria.list();
        return entitylist;
    }

    public void add(Subscribers entity) {

        persist(entity);
    }

    public void update(Subscribers entity) {
        persistupdate(entity);
    }

    public Subscribers getById(int id) {
        Subscribers subscribers = getByKey(id);
        return subscribers;
    }
}
