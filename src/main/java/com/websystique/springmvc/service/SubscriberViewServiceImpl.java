package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.SubscriberViewDao;
import com.websystique.springmvc.model.Subscriberview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("subscriberViewService")
@Transactional
public class SubscriberViewServiceImpl implements SubscriberViewService {

    @Autowired
    private SubscriberViewDao dao;


    @Override
    public List<Subscriberview> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Subscriberview> byCity(int id) {
        return dao.byCity(id);
    }

    @Override
    public List<Subscriberview> byStreet(int id) {
        return dao.byStreet(id);
    }

    @Override
    public List<Subscriberview> byBuilding(int id) {
        return dao.byBuilding(id);
    }
}
