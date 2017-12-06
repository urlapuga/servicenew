package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Tarifs;

import java.util.List;

public interface TarifDao {

    List<Tarifs> findAll();
    List<Tarifs> getByCompany(int id);
    void add(Tarifs entity);
    void update(Tarifs entity);
    Tarifs getById(int id);
    void delete(int id);

}
