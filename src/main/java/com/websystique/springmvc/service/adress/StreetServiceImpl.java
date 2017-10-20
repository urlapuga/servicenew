package com.websystique.springmvc.service.adress;

import com.websystique.springmvc.dao.adress.StreetDao;
import com.websystique.springmvc.model.address.AddrStreets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("streetService")
@Transactional
public class StreetServiceImpl implements StreetService {

    @Autowired
    private StreetDao dao;

    public List<AddrStreets> findAll() {
        return dao.findAll();
    }

    @Override
    public List<AddrStreets> byCity(int city) {
        return dao.getByCity(city);
    }

    public void add(AddrStreets entity) {
        dao.add(entity);
    }

}
