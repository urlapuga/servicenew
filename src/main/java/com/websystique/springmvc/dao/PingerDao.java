package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Pinger;
import com.websystique.springmvc.model.Tasks;

import java.util.List;

public interface PingerDao {


    List<Pinger> findAll();
    void add(Pinger pinger);
    void update(Pinger pinger);
}
