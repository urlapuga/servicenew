package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Companies;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("companyDao")
public class CompanyDaoImpl extends AbstractDao<Integer, Companies>implements CompanyDao
{

    public List<Companies> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Companies> entitylist = (List<Companies>) criteria.list();
        return entitylist;
    }

    public void add(Companies entity) {
        persist(entity);
    }

    public void update(Companies entity) {
        persistupdate(entity);
    }
}
