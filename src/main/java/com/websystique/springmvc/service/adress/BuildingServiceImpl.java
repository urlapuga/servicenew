package com.websystique.springmvc.service.adress;

import com.websystique.springmvc.dao.adress.BuildingsDao;
import com.websystique.springmvc.model.address.AddrBuildings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("buildingService")
@Transactional
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingsDao dao;

    public List<AddrBuildings> findAll() {
        return dao.findAll();
    }

    @Override
    public List<AddrBuildings> byStreet(int streetId) {
        return dao.byStreet(streetId);
    }

    public void add(AddrBuildings entity) {
        dao.add(entity);
    }

}
