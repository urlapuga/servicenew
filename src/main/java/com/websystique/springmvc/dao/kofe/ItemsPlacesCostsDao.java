package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.model.kofe.KofeItemsPlacesCosts;

import java.util.List;

public interface ItemsPlacesCostsDao {
    void delete(KofeItemsPlacesCosts k);
    void add(KofeItemsPlacesCosts k);
    List<KofeItemsPlacesCosts> findAll();
    void update(KofeItemsPlacesCosts k);
}
