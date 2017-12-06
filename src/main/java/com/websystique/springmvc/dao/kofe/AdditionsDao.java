package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.model.kofe.KofeAdditions;
import com.websystique.springmvc.model.kofe.KofeIngredients;

import java.util.List;

public interface AdditionsDao {
    List<KofeAdditions> findAll();
    void add(KofeAdditions entity);
    void update(KofeAdditions entity);
    void delete(KofeAdditions entity);
    void deleteById(int id);
    KofeAdditions getById(int id);
}
