package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.kofe.KofePlaces;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("placesDao")
public class PlacesDaoImpl extends AbstractDao<Integer, KofePlaces> implements PlacesDao {
    public List<KofePlaces> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<KofePlaces> entitylist = (List<KofePlaces>) criteria.list();
        return entitylist;
    }

    public void add(KofePlaces entity) {
        persist(entity);
    }

    public void update(KofePlaces entity) {
        persistupdate(entity);
    }

    public void delete(KofePlaces entity) {
        super.delete(entity);
    }

    public void deleteById(int id) {
        super.delete(super.getByKey(id));
    }

    public KofePlaces getById(int id) {
        return super.getByKey(id);
    }

    public List<KofePlaces> getByPin(String id) {
        return getByNamedQueryWithParam("getPlaceByPin","pin",id);
    }
}
