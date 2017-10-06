package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Pinger;
import com.websystique.springmvc.model.Tasks;

import java.util.List;

public interface PingerService {

    List<Pinger> findAll();
    void add(Pinger pinger);
    void update(Pinger pinger);
    void deleteById(int id);

}
