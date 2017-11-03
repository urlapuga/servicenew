package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Rekvizity;

import java.util.List;

public interface RekvizityDao {
    List<Rekvizity> findAll();

    Rekvizity getBySubscriber(int subscriberId);

    void add(Rekvizity entity);

    void update(Rekvizity entity);

    void delete(Rekvizity entity);

}
