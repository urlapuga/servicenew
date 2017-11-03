package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Rekvizity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("rekvizityDao")
public class RekvizityDaoImpl extends AbstractDao<Integer, Rekvizity>implements RekvizityDao
{

    public List<Rekvizity> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Rekvizity> entitylist = (List<Rekvizity>) criteria.list();
        return entitylist;
    }

    @Override
    public Rekvizity getBySubscriber(int subscriberId) {
        return super.getByNamedQueryWithParam("rekvizityBySubscriber","subscriberId",String.valueOf(subscriberId)).get(0);
    }

    public void add(Rekvizity entity) {
        persist(entity);
    }

    public void update(Rekvizity entity) {
        persistupdate(entity);
    }

    public void delete(Rekvizity entity){super.delete(entity);}

}
