package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Employees;
import com.websystique.springmvc.model.Pinger;

import java.util.List;

public interface EmployeeService {

    Employees findById(int id);
    List<Employees> findAll();
    List<Employees> findByCompanyId(int id);
    List<Employees> findByPosition(int id);
    void add(Employees pinger);
    void update(Employees pinger);


}
