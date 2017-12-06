package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.model.kofe.KofeItemTypes;

import java.util.List;

public interface KofeItemsTypesService {
     List<KofeItemTypes> findAll();

     void add(KofeItemTypes entity) ;

     void update(KofeItemTypes entity);

     void delete(KofeItemTypes entity);

     void deleteById(int id);

     KofeItemTypes getById(int id);

}
