package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.SubscriberHasTarifsDao;
import com.websystique.springmvc.model.SubscriberTarifs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("SubscriberHasTarifsService")
@Transactional
public class SubscriberHasTarifsServiceImpl implements SubscriberHasTarifsService {

    @Autowired
    private SubscriberHasTarifsDao dao;

    public void add(SubscriberTarifs entity) {

        dao.add(entity);
    }

    public void update(SubscriberTarifs entity) {
        dao.update(entity);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public SubscriberTarifs getById(int id) {
        return dao.getById(id);
    }

}
