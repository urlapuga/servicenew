package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.TaskType;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tasktypeDao")
public class TaskTypeDaoImpl extends AbstractDao<Integer, TaskType>implements TaskTypeDao
{

    @Override
    public TaskType byId(int id) {
        return getByKey(id);
    }

    public List<TaskType> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<TaskType> entitylist = (List<TaskType>) criteria.list();
        return entitylist;
    }

    public void add(TaskType entity) {
        persist(entity);
    }

    public void update(TaskType entity) {
        persistupdate(entity);
    }

    public void delete(int id) {
            Criteria crit = createEntityCriteria();
            crit.add(Restrictions.eq("id", id));
            TaskType taskType = (TaskType)crit.uniqueResult();
            super.delete(taskType);
    }
}
