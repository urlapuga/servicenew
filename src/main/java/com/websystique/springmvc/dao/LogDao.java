package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Logg;

import java.util.List;

public interface LogDao {

    List<Logg> findAll();
    void add(Logg entity);
}
