package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.OpticLines;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("opticLinesDao")
public class OpticLinesDaoImpl  extends AbstractDao<Integer, OpticLines>implements OpticLinesDao
{

    @Override
    public List<OpticLines> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<OpticLines> entitylist = (List<OpticLines>) criteria.list();
        return entitylist;
    }

    @Override
    public void add(OpticLines opticLines) {
        persist(opticLines);
    }

    @Override
    public void delete(OpticLines opticLines) {
        delete(opticLines);
    }
}
