package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.SubscriberDao;
import com.websystique.springmvc.model.Subscribers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("subscriberService")
@Transactional
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private SubscriberDao dao;

    public List<Subscribers> findAll() {
        return dao.findAll();
    }

    public void add(Subscribers entity) {
        dao.add(entity);
    }

    public void update(Subscribers entity) {
        dao.update(entity);
    }

    public Subscribers getById(int id) {
        return dao.getById(id);
    }

    @Override
    public Subscribers addGet(Subscribers subscribers) {
        return dao.addGet(subscribers);
    }
}
