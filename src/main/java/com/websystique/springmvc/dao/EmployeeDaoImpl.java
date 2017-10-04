package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Employees;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeesDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employees>implements EmployeeDao
{

    public List<Employees> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Employees> pingers = (List<Employees>) criteria.list();
        return pingers;
    }

    public void add(Employees pinger) {
        persist(pinger);
    }

    public void update(Employees pinger) {
        persistupdate(pinger);
    }
}
