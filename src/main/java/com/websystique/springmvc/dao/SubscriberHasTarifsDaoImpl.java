package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.SubscriberTarifs;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("subscriberHasTarifsDao")
public class SubscriberHasTarifsDaoImpl extends AbstractDao<Integer, SubscriberTarifs>implements SubscriberHasTarifsDao
{


    @Override
    public void add(SubscriberTarifs tarif) {
        persist(tarif);
    }

    @Override
    public void update(SubscriberTarifs tarif) {
        persistupdate(tarif);
    }

    @Override
    public void delete(int id) {
        super.delete(getByKey(id));
    }

    @Override
    public SubscriberTarifs getById(int id) {
        return super.getByKey(id);
    }

    @Override
    public List<SubscriberTarifs> getBySubscriber(int id) {
        return getByNamedQueryWithParam("TarifsOfSubscriber","subscriberID",String.valueOf(id));
    }
}
