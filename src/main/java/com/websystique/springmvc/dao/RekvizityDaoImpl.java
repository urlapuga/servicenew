package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Rekvizity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
        List<Rekvizity> rekvizity = super.getByNamedQueryWithParam("rekvizityBySubscriber","subscriberId",String.valueOf(subscriberId));
        if(rekvizity.isEmpty())return new Rekvizity();
        return rekvizity.get(0);
    }

    public void add(Rekvizity entity) {
        persist(entity);
    }

    public void update(Rekvizity entity) {
        persistupdate(entity);
    }

    public void delete(Rekvizity entity){super.delete(entity);}

}
