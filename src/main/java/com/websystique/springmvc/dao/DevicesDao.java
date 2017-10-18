package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.Devices;

import java.util.List;

public interface DevicesDao {

    List<Devices> findAll();
    void add(Devices entity);
    void delete(Devices entity);
    void deleteById(int id);
    Devices getById(int id);
}
