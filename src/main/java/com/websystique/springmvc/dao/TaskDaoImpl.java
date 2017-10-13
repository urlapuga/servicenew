package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Tasks;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("taskDao")
public class TaskDaoImpl extends AbstractDao<Integer, Tasks> implements TaskDao {
    public List<Tasks> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Tasks> users = (List<Tasks>) criteria.list();
        return users;
    }

    public void add(Tasks tasks) {
        persist(tasks);
    }

    @Override
    public List<Tasks> getManagerTasks() {
        return getByNamedQuery("managerTasks");
    }

    @Override
    public List<Tasks> getTasksByEmployeeId(int id) {
        return getByNamedQueryWithParam("byemployeeTasks","employeeId",String.valueOf(id));
    }

    @Override
    public List<Tasks> getTasksByCompany(int id) {
        return getByNamedQueryWithParam("byCompany","companyId",String.valueOf(id));

    }

    @Override
    public Tasks getById(int id) {
        return super.getByKey(id);
    }
}
