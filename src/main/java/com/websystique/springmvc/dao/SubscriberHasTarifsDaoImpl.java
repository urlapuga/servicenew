package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.SubscriberTarifs;
import org.springframework.stereotype.Repository;

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
}
