package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.Subscribers;

import java.util.List;

public interface SubscriberDao {

    List<Subscribers> findAll();
    void add(Subscribers entity);
    void update(Subscribers entity);
    Subscribers getById(int id);
}
