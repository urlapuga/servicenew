package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Employees;
import com.websystique.springmvc.model.Pinger;

import java.util.List;

public interface EmployeeDao {

    List<Employees> findAll();
    void add(Employees pinger);
    void update(Employees pinger);
}
