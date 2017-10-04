package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.PingerDao;
import com.websystique.springmvc.model.Pinger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("pingerService")
@Transactional
public class PingerServiceImpl implements PingerService {

    @Autowired
    private PingerDao dao;

    public List<Pinger> findAll() {
        return dao.findAll();
    }

    public void add(Pinger pinger) {
        dao.add(pinger);
    }

    public void update(Pinger pinger) {
        dao.update(pinger);
    }

}
