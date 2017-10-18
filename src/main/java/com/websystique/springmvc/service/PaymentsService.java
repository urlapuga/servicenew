package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Payments;

import java.util.List;

public interface PaymentsService {

    List<Payments> findAll();
    void add(Payments pinger);
    void update(Payments pinger);

}
