package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.Subscribers;

import java.util.List;

public interface SubscriberService {

    List<Subscribers> findAll();
    void add(Subscribers pinger);
    void update(Subscribers pinger);
    Subscribers getById(int id);

}
