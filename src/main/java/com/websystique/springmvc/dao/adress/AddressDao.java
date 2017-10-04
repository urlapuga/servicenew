package com.websystique.springmvc.dao.adress;

import com.websystique.springmvc.model.address.AddrAdress;

import java.util.List;

public interface AddressDao {

    List<AddrAdress> findAll();
    void add(AddrAdress entity);
    void update(AddrAdress entity);
}
