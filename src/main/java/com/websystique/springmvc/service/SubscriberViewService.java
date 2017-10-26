package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Subscriberview;

import java.util.List;

public interface SubscriberViewService {

    List<Subscriberview> findAll();
    List<Subscriberview> byCity(int id);
    List<Subscriberview> byStreet(int id);
    List<Subscriberview> byBuilding(int id);
}
