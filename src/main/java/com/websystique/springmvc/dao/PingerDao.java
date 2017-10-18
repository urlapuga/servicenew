package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Pinger;

import java.util.List;

public interface PingerDao {
    List<Pinger> findAll();
    void add(Pinger pinger);
    void update(Pinger pinger);
    void delete(int id);
}
