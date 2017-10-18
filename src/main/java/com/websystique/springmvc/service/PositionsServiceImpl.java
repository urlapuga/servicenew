package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.PositionsDao;
import com.websystique.springmvc.model.Positions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("positionsService")
@Transactional
public class PositionsServiceImpl implements PositionsService {

    @Autowired
    private PositionsDao dao;

    public List<Positions> findAll() {
        return dao.findAll();
    }

    public void add(Positions entity) {

        dao.add(entity);
    }

    public void update(Positions entity) {
        dao.update(entity);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public Positions getById(int id) {
        return dao.getById(id);
    }

}
