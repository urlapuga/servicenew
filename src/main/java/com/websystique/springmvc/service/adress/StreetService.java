package com.websystique.springmvc.service.adress;

import com.websystique.springmvc.model.address.AddrBuildings;
import com.websystique.springmvc.model.address.AddrStreets;

import java.util.List;

public interface StreetService {

    List<AddrStreets> findAll();
    void add(AddrStreets entity);

}
