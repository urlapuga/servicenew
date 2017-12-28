package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.model.kofe.KofeIngredients;
import com.websystique.springmvc.model.kofe.KofeWorkers;

import java.util.List;

public interface WorkersService {

     KofeWorkers getByPin(String pin);
     List<KofeWorkers> findAll();

     void add(KofeWorkers entity) ;

     void update(KofeWorkers entity);

     void delete(KofeWorkers entity);

     void deleteById(int id);

     KofeWorkers getById(int id);

}
