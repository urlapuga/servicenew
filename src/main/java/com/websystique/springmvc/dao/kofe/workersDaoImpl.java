package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.kofe.KofeWorkers;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("workersDao")
public class workersDaoImpl extends AbstractDao<Integer, KofeWorkers> implements workersDao
{
    public List<KofeWorkers> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<KofeWorkers> entitylist = (List<KofeWorkers>) criteria.list();
        return entitylist;
    }

    public void add(KofeWorkers entity) {
        persist(entity);
    }

    public void update(KofeWorkers entity) {
        persistupdate(entity);
    }

    public void delete(KofeWorkers entity){super.delete(entity);}

    public void deleteById(int id) {
        super.delete(super.getByKey(id));
    }

    public KofeWorkers getById(int id) {
        return super.getByKey(id);
    }

    @Override
    public KofeWorkers getByIdPin(String pin) {
        return getByNamedQueryWithParam("getWorkerByPin","pincode",pin).get(0);
    }
}
