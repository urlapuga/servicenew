package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.Positions;

import java.util.List;

public interface PositionsDao {

    List<Positions> findAll();
    void add(Positions entity);
    void update(Positions entity);
}
