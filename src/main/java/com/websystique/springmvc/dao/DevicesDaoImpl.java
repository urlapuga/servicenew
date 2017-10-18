package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Devices;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("deviceDao")
public class DevicesDaoImpl extends AbstractDao<Integer, Devices>implements DevicesDao
{

    public List<Devices> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Devices> entitylist = (List<Devices>) criteria.list();
        return entitylist;
    }

    public void add(Devices entity) {
        persist(entity);
    }


    public void delete(Devices entity){super.delete(entity);}

    @Override
    public void deleteById(int id) {
        super.delete(super.getByKey(id));
    }

    @Override
    public Devices getById(int id) {
        return super.getByKey(id);
    }
}
