package com.websystique.springmvc.dao.adress;

import com.websystique.springmvc.model.address.AddrBuildings;

import java.util.List;

public interface BuildingsDao {

    List<AddrBuildings> findAll();
    void add(AddrBuildings entity);
    void update(AddrBuildings entity);
}
