package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.dao.kofe.SmenyDao;
import com.websystique.springmvc.model.kofe.KofeSmeny;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("smenyService")
@Transactional
public class SmenyServiceImpl implements SmenyService {

    @Autowired
    private SmenyDao dao;

    public KofeSmeny getByPinWorker(String pin, String worker) {
        return dao.getByPinWorker(pin, worker);
    }

    public List<KofeSmeny> findAll() {
        return dao.findAll();
    }

    public void add(KofeSmeny entity) {

        dao.add(entity);
    }

    public void update(KofeSmeny entity) {
        dao.update(entity);
    }


}
