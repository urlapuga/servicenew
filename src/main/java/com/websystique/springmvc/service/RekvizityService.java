package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.Rekvizity;

import java.util.List;

public interface RekvizityService {
    List<Rekvizity> findAll();

    Rekvizity getBySubscriber(int subscriberId);

    void add(Rekvizity entity);

    void update(Rekvizity entity);

    void delete(Rekvizity entity);
}
