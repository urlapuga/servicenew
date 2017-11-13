package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Subscribertarifsview;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("subscriberTarifsDao")
public class SubscriberTarifsDaoImpl extends AbstractDao<Integer, Subscribertarifsview>implements SubscriberTarifsDao
{

    public List<Subscribertarifsview> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Subscribertarifsview> entitylist = (List<Subscribertarifsview>) criteria.list();
        return entitylist;
    }

    @Override
    public List<Subscribertarifsview> getBySubscriber(int id) {
        return getByNamedQueryWithParam("tarifsBySubscriber","subscriberId",String.valueOf(id));
    }

}
