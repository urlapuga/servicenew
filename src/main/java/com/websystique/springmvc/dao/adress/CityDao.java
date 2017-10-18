package com.websystique.springmvc.dao.adress;

import com.websystique.springmvc.model.address.AddrCities;

import java.util.List;

public interface CityDao {

    List<AddrCities> findAll();
    void add(AddrCities entity);
    void update(AddrCities entity);
}
