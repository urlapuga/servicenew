package com.websystique.springmvc.service.adress;

import com.websystique.springmvc.model.Tasks;
import com.websystique.springmvc.model.address.AddrAdress;
import com.websystique.springmvc.model.address.AddrBuildings;
import com.websystique.springmvc.model.address.AddrCities;
import com.websystique.springmvc.model.address.AddrStreets;

import java.util.List;

public interface AddressService {

    List<AddrAdress> findAll();
    void add(AddrAdress entity);

}
