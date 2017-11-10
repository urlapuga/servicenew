package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Logg;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("logDao")
public class LogDaoImpl extends AbstractDao<Integer, Logg>implements LogDao
{

    public List<Logg> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Logg> entitylist = (List<Logg>) criteria.list();
        return entitylist;
    }

    public void add(Logg entity) {
        persist(entity);
    }

}
