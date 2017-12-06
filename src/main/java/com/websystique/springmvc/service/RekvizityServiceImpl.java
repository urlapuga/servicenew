package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.RekvizityDao;
import com.websystique.springmvc.model.Rekvizity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("rekvizityService")
@Transactional
public class RekvizityServiceImpl implements RekvizityService {

    @Autowired
    private RekvizityDao dao;

    public List<Rekvizity> findAll() {
        return dao.findAll();
    }

    @Override
    public Rekvizity getBySubscriber(int subscriberId) {

        return dao.getBySubscriber(subscriberId);
    }

    public void add(Rekvizity entity) {

        dao.add(entity);
    }

    public void update(Rekvizity entity) {
        dao.update(entity);
    }

    @Override
    public void delete(Rekvizity entity) {
        dao.delete(entity);
    }


}
