package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Payments;

import java.util.List;

public interface PaymentsDao {

    List<Payments> findAll();
    void add(Payments entity);
    void update(Payments entity);
}
