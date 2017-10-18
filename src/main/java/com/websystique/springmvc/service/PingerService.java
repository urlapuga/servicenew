package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Pinger;

import java.util.List;

public interface PingerService {

    List<Pinger> findAll();
    void add(Pinger pinger);
    void update(Pinger pinger);
    void deleteById(int id);

}
