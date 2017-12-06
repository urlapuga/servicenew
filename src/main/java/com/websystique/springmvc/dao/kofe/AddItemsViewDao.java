package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.model.kofe.KofeAddItemView;
import com.websystique.springmvc.model.kofe.KofeAdditions;

import java.util.List;

public interface AddItemsViewDao {
    List<KofeAddItemView> findAll();
    List<KofeAddItemView> getByAddition(int id);
}
