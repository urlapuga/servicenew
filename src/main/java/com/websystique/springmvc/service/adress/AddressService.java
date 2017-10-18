package com.websystique.springmvc.service.adress;

import com.websystique.springmvc.model.address.AddrAdress;

import java.util.List;

public interface AddressService {

    List<AddrAdress> findAll();
    void add(AddrAdress entity);

}
