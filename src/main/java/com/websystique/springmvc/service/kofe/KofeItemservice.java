package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.model.kofe.KofeItemTypes;
import com.websystique.springmvc.model.kofe.KofeItems;

import java.util.List;

public interface KofeItemservice {
     List<KofeItems> findAll();

     List<KofeItems> findByType(Integer type);

     void add(KofeItems entity) ;

     void update(KofeItems entity);

     void delete(KofeItems entity);

     void deleteById(int id);

     KofeItems getById(int id);

}
