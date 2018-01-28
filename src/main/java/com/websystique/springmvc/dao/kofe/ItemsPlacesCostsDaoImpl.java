package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.kofe.KofeItemsPlacesCosts;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("itemsPlacesCostsDao")
public class ItemsPlacesCostsDaoImpl extends AbstractDao<Integer, KofeItemsPlacesCosts> implements ItemsPlacesCostsDao
{
    @Override
    public void delete(KofeItemsPlacesCosts entity) {
        KofeItemsPlacesCosts e = getByNamedQueryWithTwoParams("getByPlaceItem",
                "place", String.valueOf(entity.getPlace()),
                "item", String.valueOf(entity.getPlace())).get(0);
        super.delete(e);
    }

    @Override
    public void add(KofeItemsPlacesCosts k) {
        super.persist(k);
    }

    public List<KofeItemsPlacesCosts> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<KofeItemsPlacesCosts> entitylist = (List<KofeItemsPlacesCosts>) criteria.list();
        return entitylist;
    }

    @Override
    public void update(KofeItemsPlacesCosts k) {
        persistupdate(k);
    }

}
