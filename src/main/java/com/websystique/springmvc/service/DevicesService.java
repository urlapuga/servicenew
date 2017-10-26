package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Devices;

import java.util.List;

public interface DevicesService {

    List<Devices> findAll();
    void add(Devices entity);
    void delete(Devices entity);
    void deleteById(int id);
    Devices getById(int id);
}
