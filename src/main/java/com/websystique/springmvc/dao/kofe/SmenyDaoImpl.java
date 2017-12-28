package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.kofe.KofeSmeny;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("smenyDao")
public class SmenyDaoImpl extends AbstractDao<Integer, KofeSmeny> implements SmenyDao {
    @Override
    public KofeSmeny getByPinWorker(String pin, String workerPin) {
        List<KofeSmeny> kofeSmenies = getByNamedQueryWithTwoParams("getSmenaByPinAndWorker", "place", pin, "worker", workerPin);
        return kofeSmenies.isEmpty() ? null : kofeSmenies.get(0);
    }

    public List<KofeSmeny> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<KofeSmeny> entitylist = (List<KofeSmeny>) criteria.list();
        return entitylist;
    }

    public void add(KofeSmeny entity) {
        persist(entity);
    }

    public void update(KofeSmeny entity) {
        persistupdate(entity);
    }
}
