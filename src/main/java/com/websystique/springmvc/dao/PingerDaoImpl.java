package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Pinger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("pingerDao")
public class PingerDaoImpl extends AbstractDao<Integer, Pinger>implements PingerDao
{

    public List<Pinger> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Pinger> pingers = (List<Pinger>) criteria.list();
        return pingers;
    }

    public void add(Pinger pinger) {
        persist(pinger);
    }

    public void update(Pinger pinger) {
        persistupdate(pinger);
    }

    public void delete(int id) {
        super.delete(super.getByKey(id));
    }
}
