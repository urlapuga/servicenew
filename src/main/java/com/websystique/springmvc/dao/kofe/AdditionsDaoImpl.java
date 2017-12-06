package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.kofe.KofeAdditions;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("additionsDao")
public class AdditionsDaoImpl extends AbstractDao<Integer, KofeAdditions> implements AdditionsDao
{
    public List<KofeAdditions> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<KofeAdditions> entitylist = (List<KofeAdditions>) criteria.list();
        return entitylist;
    }

    public void add(KofeAdditions entity) {
        persist(entity);
    }

    public void update(KofeAdditions entity) {
        persistupdate(entity);
    }

    public void delete(KofeAdditions entity){super.delete(entity);}

    public void deleteById(int id) {
        super.delete(super.getByKey(id));
    }

    public KofeAdditions getById(int id) {
        return super.getByKey(id);
    }
}
