package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.kofe.KofeMainSklad;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("kofemainskladDao")
public class MainSkladDaoImpl extends AbstractDao<Integer, KofeMainSklad> implements MainSkladDao
{
    public List<KofeMainSklad> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<KofeMainSklad> entitylist = (List<KofeMainSklad>) criteria.list();
        return entitylist;
    }

    @Override
    public void addIngredient(KofeMainSklad kofeMainSklad) {
        System.out.println("updates");
       updater("addOrUpdate","ingredient",String.valueOf(kofeMainSklad.getIngredient()),
               "amount",String.valueOf(kofeMainSklad.getAmount()));
    }




}
