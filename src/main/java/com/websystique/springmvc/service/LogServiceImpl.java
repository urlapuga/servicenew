package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.LogDao;
import com.websystique.springmvc.model.Logg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("logService")
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao dao;

    public List<Logg> findAll() {
        return dao.findAll();
    }

    public void add(Logg entity) {

        dao.add(entity);
    }

}
