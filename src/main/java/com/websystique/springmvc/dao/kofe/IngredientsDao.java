package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.model.kofe.KofeIngredients;
import com.websystique.springmvc.model.kofe.KofeItems;

import java.util.List;

public interface IngredientsDao {
    List<KofeIngredients> findAll();
    void add(KofeIngredients entity);
    void update(KofeIngredients entity);
    void delete(KofeIngredients entity);
    void deleteById(int id);
    KofeIngredients getById(int id);
}
