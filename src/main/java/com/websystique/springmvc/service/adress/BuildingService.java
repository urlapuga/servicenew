package com.websystique.springmvc.service.adress;

import com.websystique.springmvc.model.address.AddrAdress;
import com.websystique.springmvc.model.address.AddrBuildings;

import java.util.List;

public interface BuildingService {

    List<AddrBuildings> findAll();
    void add(AddrBuildings entity);

}
