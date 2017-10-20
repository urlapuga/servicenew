package com.websystique.springmvc.service.adress;

import com.websystique.springmvc.model.address.AddrBuildings;

import java.util.List;

public interface BuildingService {

    List<AddrBuildings> findAll();
    List<AddrBuildings> byStreet(int streetId);

    void add(AddrBuildings entity);


}
