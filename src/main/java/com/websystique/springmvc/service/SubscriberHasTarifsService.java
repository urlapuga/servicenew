package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.SubscriberTarifs;

import java.util.List;

public interface SubscriberHasTarifsService {

    void add(SubscriberTarifs entity);
    void update(SubscriberTarifs entity);
    void delete(int id);
    SubscriberTarifs getById(int id);
    List<SubscriberTarifs> getBySubscriber(int id);
}
