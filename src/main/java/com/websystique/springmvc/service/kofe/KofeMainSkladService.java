package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.model.kofe.KofeMainSklad;

import java.util.List;

public interface KofeMainSkladService {
     List<KofeMainSklad> findAll();
     void addIngredient(KofeMainSklad kofeMainSklad);
}
