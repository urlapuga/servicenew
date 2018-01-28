package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.model.kofe.KofeAddItemView;
import com.websystique.springmvc.model.kofe.KofePlacesItemsView;

import java.util.List;

public interface PlacesItemsViewService {
     List<KofePlacesItemsView> findAll();
     List<KofePlacesItemsView> getByPlaceId(int id);

}
