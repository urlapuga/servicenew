package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.kofe.KofePlacesItemsView;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("itemsPlacesDao")
public class ItemsPlacesViewDaoImpl extends AbstractDao<Integer, KofePlacesItemsView> implements ItemsPlacesViewDao
{
    public List<KofePlacesItemsView> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<KofePlacesItemsView> entitylist = (List<KofePlacesItemsView>) criteria.list();
        return entitylist;
    }

    public List<KofePlacesItemsView> getByPlaceId(int id) {
        return getByNamedQueryWithParam("getByPlace","place",String.valueOf(id));
    }
}
