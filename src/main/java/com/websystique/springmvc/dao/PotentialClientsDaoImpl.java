package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.PotentialClients;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("potentialClientDao")
public class PotentialClientsDaoImpl extends AbstractDao<Integer, PotentialClients>implements PotentialClientsDao
{

    public List<PotentialClients> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<PotentialClients> entitylist = (List<PotentialClients>) criteria.list();
        return entitylist;
    }

    public void add(PotentialClients entity) {
        persist(entity);
    }

    public void update(PotentialClients entity) {
        persistupdate(entity);
    }
}
