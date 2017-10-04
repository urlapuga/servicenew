package com.websystique.springmvc.dao.adress;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.address.AddrAdress;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("adressDao")
public class AddressDaoImpl extends AbstractDao<Integer, AddrAdress>implements AddressDao
{

    public List<AddrAdress> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<AddrAdress> entitylist = (List<AddrAdress>) criteria.list();
        return entitylist;
    }

    public void add(AddrAdress entity) {
        persist(entity);
    }

    public void update(AddrAdress entity) {
        persistupdate(entity);
    }
}
