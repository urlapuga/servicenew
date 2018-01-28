package com.websystique.springmvc.service.kofe.temp;

import com.websystique.springmvc.dao.kofe.ItemsPlacesCostsDao;
import com.websystique.springmvc.model.kofe.KofeAddItemView;
import com.websystique.springmvc.model.kofe.KofeItemsPlacesCosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(" oplacesItemsCostService")
@Transactional
public class KofePlacesItemsCostsServiceImpl implements KofePlacesItemsCostsService {

    @Autowired
    private ItemsPlacesCostsDao dao;

    public List<KofeItemsPlacesCosts> findAll() {
        return dao.findAll();
    }

    @Override
    public void update(KofeItemsPlacesCosts k) {
        dao.update(k);
    }

    @Override
    public void add(KofeItemsPlacesCosts k) {
        dao.add(k);
    }

    @Override
    public void delete(KofeItemsPlacesCosts k) {
        dao.delete(k);
    }


}
