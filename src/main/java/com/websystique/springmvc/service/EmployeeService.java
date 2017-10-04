package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Employees;
import com.websystique.springmvc.model.Pinger;

import java.util.List;

public interface EmployeeService {

    List<Employees> findAll();
    void add(Employees pinger);
    void update(Employees pinger);

}
