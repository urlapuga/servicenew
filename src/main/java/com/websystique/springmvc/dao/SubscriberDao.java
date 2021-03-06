package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Subscribers;

import java.util.List;

public interface SubscriberDao {

    List<Subscribers> findAll();
    Subscribers addGet(Subscribers entity);
    void add(Subscribers entity);
    void update(Subscribers entity);
    Subscribers getById(int id);
}
