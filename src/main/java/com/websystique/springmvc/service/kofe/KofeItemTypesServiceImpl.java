package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.dao.CompanyDao;
import com.websystique.springmvc.dao.kofe.ItemsTypesDao;
import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.kofe.KofeItemTypes;
import com.websystique.springmvc.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("kofeitemtypesService")
@Transactional
public class KofeItemTypesServiceImpl implements KofeItemsTypesService {

    @Autowired
    private ItemsTypesDao dao;

    public List<KofeItemTypes> findAll() {
        return dao.findAll();
    }

    public void add(KofeItemTypes entity) {

        dao.add(entity);
    }

    public void update(KofeItemTypes entity) {
        dao.update(entity);
    }

    public void delete(KofeItemTypes entity) {
        dao.delete(entity);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public KofeItemTypes getById(int id) {
        return dao.getById(id);
    }

}
