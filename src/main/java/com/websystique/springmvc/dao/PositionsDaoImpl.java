package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Positions;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("positionsDao")
public class PositionsDaoImpl extends AbstractDao<Integer, Positions>implements PositionsDao
{

    @Override
    public Positions getById(int id) {
        return getByKey(id);
    }

    public List<Positions> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Positions> entitylist = (List<Positions>) criteria.list();
        return entitylist;
    }

    public void delete(int id){super.delete(getByKey(id));};

    public void add(Positions entity) {
        persist(entity);
    }

    public void update(Positions entity) {
        persistupdate(entity);
    }
}
