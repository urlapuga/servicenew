package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.kofe.KofeItemIngredientsView;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("itemingredientsviewDao")
public class ItemsIngredientsViewDaoImpl extends AbstractDao<Integer, KofeItemIngredientsView> implements ItemsIngredientsViewDao
{
    public List<KofeItemIngredientsView> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<KofeItemIngredientsView> entitylist = (List<KofeItemIngredientsView>) criteria.list();
        return entitylist;
    }

    @Override
    public List<KofeItemIngredientsView> getByItem(int id) {
        return getByNamedQueryWithParam("getIngredientsByItem","itemId",String.valueOf(id));
    }

}
