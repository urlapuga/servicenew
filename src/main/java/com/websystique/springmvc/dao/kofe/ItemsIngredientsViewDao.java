package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.model.kofe.KofeAddItemView;
import com.websystique.springmvc.model.kofe.KofeItemIngredientsView;

import java.util.List;

public interface ItemsIngredientsViewDao {
    List<KofeItemIngredientsView> findAll();
    List<KofeItemIngredientsView> getByItem(int id);
}
