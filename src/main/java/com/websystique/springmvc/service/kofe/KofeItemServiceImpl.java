package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.dao.kofe.ItemsDao;
import com.websystique.springmvc.model.kofe.KofeItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("kofeitemService")
@Transactional
public class KofeItemServiceImpl implements KofeItemservice {

    @Autowired
    private ItemsDao dao;

    public List<KofeItems> findAll() {
        return dao.findAll();
    }

    @Override
    public List<KofeItems> findByType(Integer type) {
        return dao.findByType(type);
    }

    public void add(KofeItems entity) {

        dao.add(entity);
    }

    public void update(KofeItems entity) {
        dao.update(entity);
    }

    public void delete(KofeItems entity) {
        dao.delete(entity);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public KofeItems getById(int id) {
        return dao.getById(id);
    }

}
