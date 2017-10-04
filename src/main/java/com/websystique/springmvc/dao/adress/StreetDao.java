package com.websystique.springmvc.dao.adress;

import com.websystique.springmvc.model.address.AddrStreets;

import java.util.List;

public interface StreetDao {

    List<AddrStreets> findAll();
    void add(AddrStreets entity);
    void update(AddrStreets entity);
}
