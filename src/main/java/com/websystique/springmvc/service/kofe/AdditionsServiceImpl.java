package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.dao.kofe.AdditionsDao;
import com.websystique.springmvc.model.kofe.KofeAdditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("additionsService")
@Transactional
public class AdditionsServiceImpl implements AdditionsService {

    @Autowired
    private AdditionsDao dao;

    public List<KofeAdditions> findAll() {
        return dao.findAll();
    }

    public void add(KofeAdditions entity) {
        dao.add(entity);
    }

    public void update(KofeAdditions entity) {
        dao.update(entity);
    }

    public void delete(KofeAdditions entity) {
        dao.delete(entity);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public KofeAdditions getById(int id) {
        return dao.getById(id);
    }

}
