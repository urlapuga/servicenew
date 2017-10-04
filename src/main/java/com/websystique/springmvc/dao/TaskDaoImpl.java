package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Tasks;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("taskDao")
public class TaskDaoImpl extends AbstractDao<Integer, Tasks>implements TaskDao
{


    public List<Tasks> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Tasks> users = (List<Tasks>) criteria.list();
        return users;
    }

    public void add(Tasks tasks) {
        persist(tasks);
    }
}
