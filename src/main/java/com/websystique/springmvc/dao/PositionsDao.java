package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Positions;

import java.util.List;

public interface PositionsDao {
    Positions getById(int id);
    List<Positions> findAll();
    void add(Positions entity);
    void update(Positions entity);
    void delete(int entity);
}
