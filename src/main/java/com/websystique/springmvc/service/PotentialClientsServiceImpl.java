package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.PotentialClientsDao;
import com.websystique.springmvc.model.PotentialClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("potentialClientsService")
@Transactional
public class PotentialClientsServiceImpl implements PotentialClientsService {

    @Autowired
    private PotentialClientsDao dao;

    public List<PotentialClients> findAll() {
        return dao.findAll();
    }

    public void add(PotentialClients entity) {

        dao.add(entity);
    }

    public void update(PotentialClients entity) {
        dao.update(entity);
    }

}
