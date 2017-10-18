package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.DevicesDao;
import com.websystique.springmvc.model.Devices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("devicesService")
@Transactional
public class DevicesServiceImpl implements DevicesService {

    @Autowired
    private DevicesDao dao;

    public List<Devices> findAll() {
        return dao.findAll();
    }

    public void add(Devices entity) {
        dao.add(entity);
    }

    public void delete(Devices entity) {
        dao.delete(entity);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public Devices getById(int id) {
        return dao.getById(id);
    }

}
