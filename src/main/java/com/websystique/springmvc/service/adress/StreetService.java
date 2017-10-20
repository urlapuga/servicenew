package com.websystique.springmvc.service.adress;

import com.websystique.springmvc.model.address.AddrStreets;

import java.util.List;

public interface StreetService {

    List<AddrStreets> findAll();
    List<AddrStreets> byCity(int city);
    void add(AddrStreets entity);


}
