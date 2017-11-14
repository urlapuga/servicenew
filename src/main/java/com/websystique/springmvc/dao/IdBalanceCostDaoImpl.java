package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Idbalancecost;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("idBalanceCostDao")
public class IdBalanceCostDaoImpl extends AbstractDao<Integer, Idbalancecost>implements IdBalanceCostDao {

    public List<Idbalancecost> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Idbalancecost> entitylist = (List<Idbalancecost>) criteria.list();
        return entitylist;
    }
}

