package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.model.kofe.KofeIngredients;
import com.websystique.springmvc.model.kofe.KofeSmeny;

import java.util.List;

public interface SmenyDao {
    KofeSmeny getByPinWorker(String pin,String workerPin);
    List<KofeSmeny> findAll();
    void add(KofeSmeny entity);
    void update(KofeSmeny entity);
}
