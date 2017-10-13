package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.EmployeeDao;
import com.websystique.springmvc.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("employeesService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao dao;

    @Override
    public Employees findById(int id) {
        return dao.findById(id);
    }

    public List<Employees> findAll() {
        return dao.findAll();
    }

    public List<Employees> findByCompanyId(int id) {
        return dao.findByCompany(id);
    }

    public List<Employees> findByPosition(int id) {
        return dao.findByPosition(id);
    }

    public void add(Employees pinger) {
        dao.add(pinger);
    }

    public void update(Employees pinger) {
        dao.update(pinger);
    }

}
