package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.dao.kofe.workersDao;
import com.websystique.springmvc.model.kofe.KofeWorkers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("workersService")
@Transactional
public class WorkersServiceImpl implements WorkersService {

    @Autowired
    private workersDao dao;

    @Override
    public KofeWorkers getByPin(String pin) {
        return dao.getByIdPin(pin);
    }

    public List<KofeWorkers> findAll() {
        return dao.findAll();
    }

    public void add(KofeWorkers entity) {

        dao.add(entity);
    }

    public void update(KofeWorkers entity) {
        dao.update(entity);
    }

    public void delete(KofeWorkers entity) {
        dao.delete(entity);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public KofeWorkers getById(int id) {
        return dao.getById(id);
    }

}
