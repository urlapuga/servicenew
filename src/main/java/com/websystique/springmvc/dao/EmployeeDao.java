package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Employees;
import com.websystique.springmvc.service.EmployeeService;

import java.util.List;

public interface EmployeeDao {

    List<Employees> findAll();
    void add(Employees pinger);
    void update(Employees pinger);
    List<Employees> findByCompany(int id);
    List<Employees> findByPosition(int id);
    Employees findById(int id);
    Employees getByLoginPass(String login,String pass);
}
