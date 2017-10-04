package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.CompanyDao;
import com.websystique.springmvc.model.Companies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("companiesService")
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao dao;

    public List<Companies> findAll() {
        return dao.findAll();
    }

    public void add(Companies entity) {

        dao.add(entity);
    }

    public void update(Companies entity) {
        dao.update(entity);
    }

}
