package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.model.kofe.KofeAddItemView;
import com.websystique.springmvc.model.kofe.KofeItemIngredientsView;

import java.util.List;

public interface ItemIngredientsViewService {
     List<KofeItemIngredientsView> findAll();
     List<KofeItemIngredientsView> findByItem(int id);

}
