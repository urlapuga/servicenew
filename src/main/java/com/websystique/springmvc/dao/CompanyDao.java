package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Companies;

import java.util.List;

public interface CompanyDao {

    List<Companies> findAll();
    void add(Companies entity);
    void update(Companies entity);
    void delete(Companies entity);
    void deleteById(int id);
    Companies getById(int id);
}
