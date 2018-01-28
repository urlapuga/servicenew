package com.websystique.springmvc.service.kofe.temp;

import com.websystique.springmvc.model.kofe.KofeAddItemView;
import com.websystique.springmvc.model.kofe.KofeItemsPlacesCosts;

import java.util.List;

public interface KofePlacesItemsCostsService {
     List<KofeItemsPlacesCosts> findAll();
     void update(KofeItemsPlacesCosts k);
     void add(KofeItemsPlacesCosts k);
     void delete(KofeItemsPlacesCosts k);
}
