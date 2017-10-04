package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.PotentialClients;

import java.util.List;

public interface PotentialClientsService {

    List<PotentialClients> findAll();
    void add(PotentialClients entity);
    void update(PotentialClients entity);

}
