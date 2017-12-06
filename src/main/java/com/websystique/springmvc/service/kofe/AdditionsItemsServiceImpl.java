package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.dao.kofe.AdditionsItemsDao;
import com.websystique.springmvc.model.kofe.KofeAdditionsItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("additionsitemsService")
@Transactional
public class AdditionsItemsServiceImpl implements AdditionsItemsService {

    @Autowired
    private AdditionsItemsDao dao;

    public List<KofeAdditionsItems> findAll() {
        return dao.findAll();
    }

    public void add(KofeAdditionsItems entity) {
        dao.add(entity);
    }

    public void update(KofeAdditionsItems entity) {
        dao.update(entity);
    }

    public void delete(KofeAdditionsItems entity) {
        dao.delete(entity);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public KofeAdditionsItems getById(int id) {
        return dao.getById(id);
    }

}
