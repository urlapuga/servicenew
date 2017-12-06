package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.model.kofe.KofeMainSklad;

import java.util.List;

public interface MainSkladDao {
    List<KofeMainSklad> findAll();
    void addIngredient(KofeMainSklad kofeMainSklad);
}
