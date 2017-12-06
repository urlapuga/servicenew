package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.dao.CompanyDao;
import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.kofe.KofeItemTypes;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("kofeitemtypesDao")
public class ItemsTypesDaoImpl extends AbstractDao<Integer, KofeItemTypes> implements ItemsTypesDao
{
    public List<KofeItemTypes> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<KofeItemTypes> entitylist = (List<KofeItemTypes>) criteria.list();
        return entitylist;
    }

    public void add(KofeItemTypes entity) {
        persist(entity);
    }

    public void update(KofeItemTypes entity) {
        persistupdate(entity);
    }

    public void delete(KofeItemTypes entity){super.delete(entity);}

    public void deleteById(int id) {
        super.delete(super.getByKey(id));
    }

    public KofeItemTypes getById(int id) {
        return super.getByKey(id);
    }
}
