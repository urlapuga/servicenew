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

    public List<Employees> findAll() {
        return dao.findAll();
    }

    public void add(Employees pinger) {
        dao.add(pinger);
    }

    public void update(Employees pinger) {
        dao.update(pinger);
    }

}
