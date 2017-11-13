package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.Subscribertarifsview;

import java.util.List;

public interface SubscriberTarifsService {

    List<Subscribertarifsview> findAll();
    List<Subscribertarifsview> getBySubscriber(int id);
}
