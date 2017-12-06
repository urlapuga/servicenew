package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.TarifDao;
import com.websystique.springmvc.model.Tarifs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("tarifService")
@Transactional
public class TarifServiceImpl implements TarifService {

    @Autowired
    private TarifDao dao;

    public List<Tarifs> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Tarifs> findByCompany(int id) {
        return dao.getByCompany(id);
    }

    public void add(Tarifs entity) {

        dao.add(entity);
    }

    public void update(Tarifs entity) {
        dao.update(entity);
    }

    public Tarifs getById(int id) {
        return dao.getById(id);
    }

    public void delete(int id) {
        dao.delete(id);
    }


}
