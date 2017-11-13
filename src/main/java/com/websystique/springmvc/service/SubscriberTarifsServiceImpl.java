package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.SubscriberTarifsDao;
import com.websystique.springmvc.model.Subscribertarifsview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("subscriberTarifsService")
@Transactional
public class SubscriberTarifsServiceImpl implements SubscriberTarifsService {

    @Autowired
    private SubscriberTarifsDao dao;

    public List<Subscribertarifsview> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Subscribertarifsview> getBySubscriber(int id) {
        return dao.getBySubscriber(id);
    }


}
