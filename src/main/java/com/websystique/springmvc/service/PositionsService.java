package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.Positions;

import java.util.List;

public interface PositionsService {

    List<Positions> findAll();
    void add(Positions pinger);
    void update(Positions pinger);

}
