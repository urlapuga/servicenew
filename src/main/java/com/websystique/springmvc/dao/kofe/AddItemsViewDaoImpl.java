package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.kofe.KofeAddItemView;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("additemviewDao")
public class AddItemsViewDaoImpl extends AbstractDao<Integer, KofeAddItemView> implements AddItemsViewDao
{
    public List<KofeAddItemView> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<KofeAddItemView> entitylist = (List<KofeAddItemView>) criteria.list();
        return entitylist;
    }

    @Override
    public List<KofeAddItemView> getByAddition(int id) {
        return getByNamedQueryWithParam("getitemsbyaddition","additionId",String.valueOf(id));
    }

}
