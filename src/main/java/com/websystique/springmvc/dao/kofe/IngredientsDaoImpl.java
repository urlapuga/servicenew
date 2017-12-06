package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.kofe.KofeIngredients;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ingredientsDao")
public class IngredientsDaoImpl extends AbstractDao<Integer, KofeIngredients> implements IngredientsDao
{
    public List<KofeIngredients> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<KofeIngredients> entitylist = (List<KofeIngredients>) criteria.list();
        return entitylist;
    }

    public void add(KofeIngredients entity) {
        persist(entity);
    }

    public void update(KofeIngredients entity) {
        persistupdate(entity);
    }

    public void delete(KofeIngredients entity){super.delete(entity);}

    public void deleteById(int id) {
        super.delete(super.getByKey(id));
    }

    public KofeIngredients getById(int id) {
        return super.getByKey(id);
    }
}
