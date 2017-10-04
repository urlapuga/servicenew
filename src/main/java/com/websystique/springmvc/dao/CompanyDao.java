package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.Employees;

import java.util.List;

public interface CompanyDao {

    List<Companies> findAll();
    void add(Companies entity);
    void update(Companies entity);
}
