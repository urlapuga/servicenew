package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Tarifs;

import java.util.List;

public interface TarifService {

    List<Tarifs> findAll();
    List<Tarifs> findByCompany(int id);
    void add(Tarifs pinger);
    void update(Tarifs pinger);
    Tarifs getById(int id);
    void delete(int id);

}
