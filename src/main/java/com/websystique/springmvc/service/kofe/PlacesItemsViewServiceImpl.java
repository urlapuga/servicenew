package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.dao.kofe.ItemsPlacesViewDao;
import com.websystique.springmvc.model.kofe.KofePlacesItemsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("placesitemsviewService")
@Transactional
public class PlacesItemsViewServiceImpl implements PlacesItemsViewService {

    @Autowired
    ItemsPlacesViewDao dao;

    public List<KofePlacesItemsView> findAll() {
        return dao.findAll();
    }

    public List<KofePlacesItemsView> getByPlaceId(int id) {
        return dao.getByPlaceId(id);
    }

}
