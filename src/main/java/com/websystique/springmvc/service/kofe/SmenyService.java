package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.kofe.KofeSmeny;

import java.util.List;

public interface SmenyService {

    KofeSmeny getByPinWorker(String pin,String worker);
    List<KofeSmeny> findAll();
    void add(KofeSmeny entity);
    void update(KofeSmeny entity);
}
