package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Logg;

import java.util.List;

public interface LogService {

    List<Logg> findAll();
    void add(Logg entity);
}
