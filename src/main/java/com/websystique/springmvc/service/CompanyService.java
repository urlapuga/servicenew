package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.Employees;

import java.util.List;

public interface CompanyService {

    List<Companies> findAll();
    void add(Companies pinger);
    void update(Companies pinger);

}
