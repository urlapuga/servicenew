package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.model.kofe.KofeAdditionsItems;

import java.util.List;

public interface AdditionsItemsService {
     List<KofeAdditionsItems> findAll();

     void add(KofeAdditionsItems entity) ;

     void update(KofeAdditionsItems entity);

     void delete(KofeAdditionsItems entity);

     void deleteById(int id);

     KofeAdditionsItems getById(int id);

}
