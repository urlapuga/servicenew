package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.model.kofe.KofeAdditions;
import com.websystique.springmvc.model.kofe.KofePlacesItemsView;

import java.util.List;

public interface ItemsPlacesViewDao {
    List<KofePlacesItemsView> findAll();
    List<KofePlacesItemsView> getByPlaceId(int id);
}
