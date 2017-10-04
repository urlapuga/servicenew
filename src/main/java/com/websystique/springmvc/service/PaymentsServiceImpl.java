package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.PaymentsDao;
import com.websystique.springmvc.model.Payments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("paymentsService")
@Transactional
public class PaymentsServiceImpl implements PaymentsService {

    @Autowired
    private PaymentsDao dao;

    public List<Payments> findAll() {
        return dao.findAll();
    }

    public void add(Payments entity) {

        dao.add(entity);
    }

    public void update(Payments entity) {
        dao.update(entity);
    }

}
