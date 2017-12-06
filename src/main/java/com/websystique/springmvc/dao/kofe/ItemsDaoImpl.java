package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.kofe.KofeItems;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("kofeitemDao")
public class ItemsDaoImpl extends AbstractDao<Integer, KofeItems> implements ItemsDao
{
    public List<KofeItems> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<KofeItems> entitylist = (List<KofeItems>) criteria.list();
        return entitylist;
    }

    public void add(KofeItems entity) {
        persist(entity);
    }

    public void update(KofeItems entity) {
        persistupdate(entity);
    }

    public void delete(KofeItems entity){super.delete(entity);}

    public void deleteById(int id) {
        super.delete(super.getByKey(id));
    }

    public KofeItems getById(int id) {
        return super.getByKey(id);
    }
}
