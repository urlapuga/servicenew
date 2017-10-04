package com.websystique.springmvc.service.adress;

import com.websystique.springmvc.dao.adress.CityDao;
import com.websystique.springmvc.model.address.AddrCities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("citiesService")
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao dao;

    public List<AddrCities> findAll() {
        return dao.findAll();
    }

    public void add(AddrCities entity) {
        dao.add(entity);
    }

}
