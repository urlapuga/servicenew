package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.SubscriberTarifs;
import com.websystique.springmvc.model.Subscribertarifsview;

import java.util.List;

public interface SubscriberHasTarifsDao {
    void add(SubscriberTarifs tarif);
    void update(SubscriberTarifs tarif);
    void delete(int id);
    SubscriberTarifs getById(int id);
}
