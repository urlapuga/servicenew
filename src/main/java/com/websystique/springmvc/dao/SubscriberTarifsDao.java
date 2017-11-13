package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.Subscribertarifsview;

import java.util.List;

public interface SubscriberTarifsDao {

    List<Subscribertarifsview> findAll();
    List<Subscribertarifsview> getBySubscriber(int id);
}
