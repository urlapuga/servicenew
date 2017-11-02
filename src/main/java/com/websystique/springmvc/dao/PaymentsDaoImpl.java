package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Payments;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("paymentsDao")
public class PaymentsDaoImpl extends AbstractDao<Integer, Payments>implements PaymentsDao
{
    @Override
    public List<Payments> bySubscriber(int id) {
        return super.getByNamedQueryWithParam("paymentsBySubscriber","subscriberId",String.valueOf(id));
    }

    public List<Payments> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Payments> entitylist = (List<Payments>) criteria.list();
        return entitylist;
    }

    public void add(Payments entity) {
        persist(entity);
    }

    public void update(Payments entity) {
        persistupdate(entity);
    }
}
