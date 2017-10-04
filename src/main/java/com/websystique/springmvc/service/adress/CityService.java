package com.websystique.springmvc.service.adress;

import com.websystique.springmvc.model.address.AddrCities;
import com.websystique.springmvc.model.address.AddrStreets;

import java.util.List;

public interface CityService {

    List<AddrCities> findAll();
    void add(AddrCities entity);

}
