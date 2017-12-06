package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.model.kofe.KofeIngredients;
import com.websystique.springmvc.model.kofe.KofePlaces;

import java.util.List;

public interface PlacesDao {
    List<KofePlaces> findAll();
    void add(KofePlaces entity);
    void update(KofePlaces entity);
    void delete(KofePlaces entity);
    void deleteById(int id);
    KofePlaces getById(int id);
    List<KofePlaces> getByPin(String id);
}
