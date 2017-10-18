package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.PotentialClients;

import java.util.List;

public interface PotentialClientsDao {

    List<PotentialClients> findAll();
    void add(PotentialClients entity);
    void update(PotentialClients entity);
}
