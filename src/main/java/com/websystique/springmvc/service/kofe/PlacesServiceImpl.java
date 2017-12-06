package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.dao.kofe.PlacesDao;
import com.websystique.springmvc.model.kofe.KofePlaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("placesService")
@Transactional
public class PlacesServiceImpl implements PlacesService {

    @Autowired
    private PlacesDao dao;

    public List<KofePlaces> findAll() {
        return dao.findAll();
    }

    public void add(KofePlaces entity) {

        dao.add(entity);
    }

    public void update(KofePlaces entity) {
        dao.update(entity);
    }

    public void delete(KofePlaces entity) {
        dao.delete(entity);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public KofePlaces getById(int id) {
        return dao.getById(id);
    }

    @Override
    public List<KofePlaces> getBuPin(String pin) {
        return dao.getByPin(pin);
    }

}
