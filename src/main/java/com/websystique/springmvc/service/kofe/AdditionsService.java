package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.model.kofe.KofeAdditions;
import com.websystique.springmvc.model.kofe.KofeIngredients;

import java.util.List;

public interface AdditionsService {
     List<KofeAdditions> findAll();

     void add(KofeAdditions entity) ;

     void update(KofeAdditions entity);

     void delete(KofeAdditions entity);

     void deleteById(int id);

     KofeAdditions getById(int id);

}
