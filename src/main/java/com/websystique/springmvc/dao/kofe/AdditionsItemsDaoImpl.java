package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.kofe.KofeAdditionsItems;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("additionsitemsDao")
public class AdditionsItemsDaoImpl extends AbstractDao<Integer, KofeAdditionsItems> implements AdditionsItemsDao
{
    public List<KofeAdditionsItems> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<KofeAdditionsItems> entitylist = (List<KofeAdditionsItems>) criteria.list();
        return entitylist;
    }

    public void add(KofeAdditionsItems entity) {
        persist(entity);
    }

    public void update(KofeAdditionsItems entity) {
        persistupdate(entity);
    }

    public void delete(KofeAdditionsItems entity){super.delete(entity);}

    public void deleteById(int id) {
        super.delete(super.getByKey(id));
    }

    public KofeAdditionsItems getById(int id) {
        return super.getByKey(id);
    }
}
