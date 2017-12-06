package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Tarifs;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tarifDao")
public class TarifDaoImpl extends AbstractDao<Integer, Tarifs>implements TarifDao
{

    public List<Tarifs> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Tarifs> entitylist = (List<Tarifs>) criteria.list();
        return entitylist;
    }

    @Override
    public List<Tarifs> getByCompany(int id) {
        return getByNamedQueryWithParam("getTarifsByCompany","companyId",String.valueOf(id));
    }

    public void add(Tarifs entity) {
        persist(entity);
    }

    public void update(Tarifs entity) {
        persistupdate(entity);
    }

    public Tarifs getById(int id) {
        Tarifs entity = getByKey(id);
        return entity;
    }

    public void delete(int id) {
        delete(getById(id));
    }
}
